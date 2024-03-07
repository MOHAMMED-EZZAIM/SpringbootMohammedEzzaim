package org.example.bankapplicationbackend.service;

import org.example.bankapplicationbackend.Exception.BalancenotFoundException;
import org.example.bankapplicationbackend.Exception.BankAcountNotFoundException;
import org.example.bankapplicationbackend.Exception.CustomerNotFoundException;
import org.example.bankapplicationbackend.bean.BankAccount;
import org.example.bankapplicationbackend.web.dtos.*;

import java.util.List;
public interface BankAccountService {
     List<BankAccountDto> bankAccountDtoList();

     BankAccountDto getBanKAccount(String accountId) throws BankAcountNotFoundException;
     CustomerDto saveCustomer(CustomerDto customerDto);
     CurrentAcountDto saveCurrentBankAccount(double initilBalance,
                                             double overDraft,
                                             Long CustomerId) throws CustomerNotFoundException;

     SavingAcountDto saveSavingBankAccount(double initilBalance,
                                           double interstRate,
                                           Long CustomerId) throws CustomerNotFoundException;

     List<CustomerDto> listCustomer();
     void debit(String accounID, double amout, double v, String description) throws BankAcountNotFoundException, BalancenotFoundException;
     void creadit(String accounID, double amout, double v, String description) throws BalancenotFoundException, BankAcountNotFoundException;
     void transfert(String accounIdSource,String accounIdDestination,double amout) throws BankAcountNotFoundException, BalancenotFoundException;
     CustomerDto getCustomerDto(Long customerId) throws CustomerNotFoundException;

     CustomerDto updateCustomer(CustomerDto customerDto);

     void deleteCusteomer(Long costomerId);

     List<AccountOperationDto> accounthistory(String accounId);

     AccounthistoryDto getAccounthistory(String accountId, int page, int size) throws BankAcountNotFoundException;
}
