package org.example.bankapplicationbackend;

import org.example.bankapplicationbackend.bean.*;
import org.example.bankapplicationbackend.dao.AccountOperationDao;
import org.example.bankapplicationbackend.dao.BankAccountDao;
import org.example.bankapplicationbackend.dao.CustomerDao;
import org.example.bankapplicationbackend.enums.AcountStatus;
import org.example.bankapplicationbackend.enums.OperationType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankApplicationBackendApplication {
    public  int i;
    public static void main(String[] args) {
        SpringApplication.run(BankApplicationBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(CustomerDao customerDao,
                               BankAccountDao bankAccountDao,
                               AccountOperationDao accountOperationDao) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerDao.save(customer);
            });
            customerDao.findAll().forEach(customer -> {
                CurrentAcount currentAccount = new CurrentAcount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 909090);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AcountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(9000);
                bankAccountDao.save(currentAccount);
            });
            customerDao.findAll().forEach(customer -> {
                SavingAcount savingAccount = new SavingAcount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 909090);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AcountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRat(5.5);
                bankAccountDao.save(savingAccount);
            });
            bankAccountDao.findAll().forEach(bankAccount -> {
                for (int i = 0; i < 10; i++) {
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperarionDate(new Date());
                    accountOperation.setAmount(Math.random() * 12000);
                    accountOperation.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperation.setBankAccount(bankAccount);
                    accountOperationDao.save(accountOperation);
                }
            });
        };
    }
//    @Bean
//   CommandLineRunner printData(CustomerDao customerDao,
//                              BankAccountDao bankAccountDao,
//                               AccountOperationDao accountOperationDao) {
//    CommandLineRunner printData(BankService bankService) {
//        return args -> {
//            bankService.consulter();
//            BankAccount bankAccount = bankAccountDao.findById("0d7a8f3d-6e9b-4efe-a2b4-cc5c7efb2300").orElse(null);
//            if (bankAccount != null) {
//                System.out.println("------------------------------------------------------");
//                System.out.println("info bankAccount :");
//                System.out.println(bankAccount.getId());
//                System.out.println(bankAccount.getBalance());
//                System.out.println(bankAccount.getStatus());
//                System.out.println(bankAccount.getCreatedAt());
//                System.out.println(bankAccount.getCustomer().getName());
//                System.out.println(bankAccount.getClass().getSimpleName());
//                if (bankAccount instanceof CurrentAcount) {
//                    System.out.println(((CurrentAcount) bankAccount).getOverDraft());
//                } else if (bankAccount instanceof SavingAcount) {
//                    System.out.println(((SavingAcount) bankAccount).getInterestRat());
//                }
//                System.out.println("------------------------------------------------------");
//
//                bankAccount.getAccountOperationList().forEach(aopera -> {
//                    i++;
//                    System.out.println("*************************");
//                    System.out.println("Operation Acount"+i+":");
//                    System.out.println(aopera.getType());
//                    System.out.println(aopera.getOperarionDate());
//                    System.out.println(aopera.getAmount());
//                });
//            }
//        };
//    }
}


