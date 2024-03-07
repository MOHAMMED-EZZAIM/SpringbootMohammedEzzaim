package org.example.bankapplicationbackend;

import org.example.bankapplicationbackend.Exception.BalancenotFoundException;
import org.example.bankapplicationbackend.Exception.BankAcountNotFoundException;
import org.example.bankapplicationbackend.Exception.CustomerNotFoundException;
import org.example.bankapplicationbackend.bean.*;
import org.example.bankapplicationbackend.dao.AccountOperationDao;
import org.example.bankapplicationbackend.dao.BankAccountDao;
import org.example.bankapplicationbackend.dao.CustomerDao;
import org.example.bankapplicationbackend.enums.AcountStatus;
import org.example.bankapplicationbackend.enums.OperationType;
import org.example.bankapplicationbackend.service.BankAccountService;
import org.example.bankapplicationbackend.web.dtos.BankAccountDto;
import org.example.bankapplicationbackend.web.dtos.CurrentAcountDto;
import org.example.bankapplicationbackend.web.dtos.CustomerDto;
import org.example.bankapplicationbackend.web.dtos.SavingAcountDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication

public class BankApplicationBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplicationBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(BankAccountService bankAccountService) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
                CustomerDto customer = new CustomerDto();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomer().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random() * 90000, 9000, customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random() * 120000, 5.5, customer.getId());

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
            List<BankAccountDto> bankAccountLists=bankAccountService.bankAccountDtoList();
            bankAccountLists.forEach(account -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        String accounId;
                        if(account instanceof SavingAcountDto){
                            accounId=((SavingAcountDto) account).getId();
                        }else {
                            accounId=((CurrentAcountDto) account).getId();
                        }
                        bankAccountService.creadit(accounId, 10000, Math.random() * 12000, "Creadit");
                        bankAccountService.debit(accounId, 1000, Math.random() * 90000, "Debit");
                    } catch (BalancenotFoundException | BankAcountNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        };
    }
}
