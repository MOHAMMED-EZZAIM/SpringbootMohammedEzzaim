package org.example.bankapplicationbackend.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.bankapplicationbackend.Exception.BalancenotFoundException;
import org.example.bankapplicationbackend.Exception.BankAcountNotFoundException;
import org.example.bankapplicationbackend.Exception.CustomerNotFoundException;
import org.example.bankapplicationbackend.bean.*;
import org.example.bankapplicationbackend.dao.AccountOperationDao;
import org.example.bankapplicationbackend.dao.BankAccountDao;
import org.example.bankapplicationbackend.dao.CustomerDao;
import org.example.bankapplicationbackend.enums.OperationType;
import org.example.bankapplicationbackend.web.converter.AccountOperationConverter;
import org.example.bankapplicationbackend.web.converter.CurrentAcountConverter;
import org.example.bankapplicationbackend.web.converter.CustomerConverter;
import org.example.bankapplicationbackend.web.converter.SavingAcountConverter;
import org.example.bankapplicationbackend.web.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
@Transactional
@Slf4j
public class BankAccountServiceImpl implements  BankAccountService{
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private BankAccountDao bankAccountDao;
    @Autowired
    private AccountOperationDao accountOperationDao;
    @Autowired
    private CustomerConverter customers;
    @Autowired
    private CustomerConverter converter;
    @Autowired
    private CurrentAcountConverter currentAcountConverter;
    @Autowired
    private SavingAcountConverter savingAcountConverter;


    private AccountOperationConverter accountOperationConverter;
    //Slf4j : hader hadef der like mesage  fache tesiver
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        log.info("saving new Customer!");
        Customer customer=converter.toBean(customerDto);
        Customer saveCustomer = customerDao.save(customer);
        return converter.toDto(saveCustomer);
    }

    @Override
    public CurrentAcountDto saveCurrentBankAccount(double initilBalance, double overDraft, Long CustomerId) throws CustomerNotFoundException {

        Customer customer=customerDao.findById(CustomerId).orElse(null);
        if(customer==null){
            throw new CustomerNotFoundException("Customer not found");
        }
        CurrentAcount currentAcount=new CurrentAcount();
        currentAcount.setId(UUID.randomUUID().toString());
        currentAcount.setCreatedAt(new Date());
        currentAcount.setBalance(initilBalance);
        currentAcount.setOverDraft(overDraft);
        currentAcount.setCustomer(customer);
        CurrentAcount saveBankAccount = bankAccountDao.save(currentAcount);
        return currentAcountConverter.toDto(saveBankAccount);
    }

    @Override
    public SavingAcountDto saveSavingBankAccount(double initilBalance, double interstRate, Long CustomerId) throws CustomerNotFoundException {
        Customer customer=customerDao.findById(CustomerId).orElse(null);
        if(customer==null){
            throw new CustomerNotFoundException("Customer not found");
        }
        SavingAcount savingAcount=new SavingAcount();
        savingAcount.setCreatedAt(new Date());
        savingAcount.setBalance(initilBalance);
        savingAcount.setId(UUID.randomUUID().toString());
        savingAcount.setInterestRat(interstRate);
        savingAcount.setCustomer(customer);
        SavingAcount saveBankAccount = bankAccountDao.save(savingAcount);
        return savingAcountConverter.toDto(saveBankAccount);
    }


    @Override
    public List<CustomerDto> listCustomer() {
        List<Customer> customerList=customerDao.findAll();
        return customers.toDto(customerList);
    }

    @Override
    public List<BankAccountDto> bankAccountDtoList(){
        List<BankAccount> bankAccountList=bankAccountDao.findAll();
        List<BankAccountDto> collect = bankAccountList.stream().map(bankAccount -> {
            if (bankAccount instanceof SavingAcount) {
                SavingAcount savingAcount = (SavingAcount) bankAccount;
                return savingAcountConverter.toDto(savingAcount);
            } else {
                CurrentAcount currentAcount = (CurrentAcount) bankAccount;
                return currentAcountConverter.toDto(currentAcount);
            }
        }).collect(Collectors.toList());
return  collect;
    }

    @Override
    public BankAccountDto getBanKAccount(String accountId) throws BankAcountNotFoundException {

        BankAccount bankAccount= bankAccountDao.findById(accountId).
                orElseThrow(()->new
                        BankAcountNotFoundException("Banck not found Exception"));
        if(bankAccount instanceof SavingAcount){
            SavingAcount savingAcount= (SavingAcount) bankAccount;
            return  savingAcountConverter.toDto(savingAcount);
        }else{
            CurrentAcount currentAcount= (CurrentAcount) bankAccount;
            return  currentAcountConverter.toDto(currentAcount);
        }
    }

    @Override
    public void debit(String accounID, double amout, double v, String description) throws BankAcountNotFoundException, BalancenotFoundException {

        BankAccount bankAccount= bankAccountDao.findById(accounID).
                orElseThrow(()->new
                        BankAcountNotFoundException("Banck not found Exception"));
        if(bankAccount.getBalance()<amout){
            throw new BalancenotFoundException("sold no found");
        }
        AccountOperation accountOperation=new AccountOperation();
        accountOperation.setType(OperationType.DEBIT);
        accountOperation.setAmount(amout);
        accountOperation.setDescription(description);
        accountOperation.setOperarionDate(new Date());
        accountOperation.setBankAccount(bankAccount);
        accountOperationDao.save(accountOperation);
        bankAccount.setBalance(bankAccount.getBalance()-amout);
        bankAccountDao.save(bankAccount);
    }

    @Override
    public void creadit(String accounID, double amout, double v, String description) throws BalancenotFoundException, BankAcountNotFoundException {

        BankAccount bankAccount= bankAccountDao.findById(accounID).
                orElseThrow(()->new
                        BankAcountNotFoundException("Banck not found Exception"));
        AccountOperation accountOperation=new AccountOperation();
        accountOperation.setType(OperationType.CREDIT);
        accountOperation.setAmount(amout);
        accountOperation.setDescription(description);
        accountOperation.setOperarionDate(new Date());
        accountOperation.setBankAccount(bankAccount);
        accountOperationDao.save(accountOperation);
        bankAccount.setBalance(bankAccount.getBalance()+amout);
        bankAccountDao.save(bankAccount);
    }

    @Override
    public void transfert(String accounIdSource, String accounIdDestination, double amout) throws BankAcountNotFoundException, BalancenotFoundException {
        debit(accounIdSource,amout, Math.random() * 90000, "Transfert to "+accounIdDestination);
        creadit(accounIdDestination,amout, Math.random() * 12000, "Transfert from "+accounIdSource);
    }

    @Override
    public CustomerDto getCustomerDto(Long customerId) throws CustomerNotFoundException {
        Customer customer=    customerDao.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("Custemer not found"));
        System.out.println(customer.getName());
        System.out.println(customer.getEmail());
        return converter.toDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        log.info("saving new Customer!");
        Customer customer=converter.toBean(customerDto);
        Customer saveCustomer = customerDao.save(customer);
        return converter.toDto(saveCustomer);
    }

    @Override
    public void deleteCusteomer(Long costomerId){
         customerDao.deleteById(costomerId);
    }

    @Override
    public  List<AccountOperationDto> accounthistory(String accounId){
        List<AccountOperation> byBankAccountId = accountOperationDao.findByBankAccountId(accounId);
      return   byBankAccountId.stream().map(op-> accountOperationConverter.toDto(op)).collect(Collectors.toList());
    }

    @Override
    public AccounthistoryDto getAccounthistory(String accountId, int page, int size) throws BankAcountNotFoundException {
        BankAccount bankAccount=bankAccountDao.findById(accountId).orElse(null);
        if(bankAccount==null){
            throw new BankAcountNotFoundException("Account not found Exception");
        }
     Page<AccountOperation> accountOperationPage=  accountOperationDao.findByBankAccountId(accountId, PageRequest.of(page,size));
     AccounthistoryDto accounthistoryDto=new AccounthistoryDto();
       List<AccountOperationDto> accountOperationDtos= accountOperationPage.getContent().stream().map(op->accountOperationConverter.toDto(op)).collect(Collectors.toList());
        accounthistoryDto.setAccounthistoryDtoList(accountOperationDtos);
        accounthistoryDto.setAccounId(bankAccount.getId());
        accounthistoryDto.setBalance(bankAccount.getBalance());
        accounthistoryDto.setPageSize(size);
        accounthistoryDto.setCurrentPages(page);
        accounthistoryDto.setTotalPages(accountOperationPage.getTotalPages());
        return accounthistoryDto;
    }

}
