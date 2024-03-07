package org.example.bankapplicationbackend.web.facade;

import org.example.bankapplicationbackend.Exception.BankAcountNotFoundException;
import org.example.bankapplicationbackend.service.BankAccountService;
import org.example.bankapplicationbackend.web.dtos.AccountOperationDto;
import org.example.bankapplicationbackend.web.dtos.AccounthistoryDto;
import org.example.bankapplicationbackend.web.dtos.BankAccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService=bankAccountService;
    }

    @GetMapping("/acount/{accountId}")
    public BankAccountDto getBankAccount(@PathVariable  String accountId) throws BankAcountNotFoundException {
        return  bankAccountService.getBanKAccount(accountId);
    }

    @GetMapping("/acounts")
    public List<BankAccountDto> bankAccountDtoList(){
        return bankAccountService.bankAccountDtoList();
    }

    @GetMapping("/accounts/{accountId}")
    public List<AccountOperationDto> getHistory(@PathVariable String accountId){
        return bankAccountService.accounthistory(accountId);
    }
    @GetMapping("/accountsPage/{accountId}/")
    public AccounthistoryDto getAccounthistoryDto(@PathVariable String accountId,
                                                  @RequestParam(name = "page",defaultValue = "0") int page,
                                                  @RequestParam(name = "size",defaultValue = "5") int size) throws BankAcountNotFoundException {
        return bankAccountService.getAccounthistory(accountId,page,size);
    }


}
