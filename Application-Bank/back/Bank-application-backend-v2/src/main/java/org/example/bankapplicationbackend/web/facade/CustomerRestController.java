package org.example.bankapplicationbackend.web.facade;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.bankapplicationbackend.Exception.CustomerNotFoundException;
import org.example.bankapplicationbackend.bean.Customer;
import org.example.bankapplicationbackend.service.BankAccountService;
import org.example.bankapplicationbackend.web.dtos.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@AllArgsConstructor @NoArgsConstructor
@Slf4j
public class CustomerRestController {
    @Autowired
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDto> customerList(){
        return  bankAccountService.listCustomer();
    }
    @GetMapping("/customers/{customerId}")
    public  CustomerDto getCustomerDto(@PathVariable Long customerId) throws CustomerNotFoundException {
        return  bankAccountService.getCustomerDto(customerId);
    }

    @PostMapping("/customers")
    public CustomerDto saveCustomer(@RequestBody  CustomerDto customerDto){
        return bankAccountService.saveCustomer(customerDto);
    }

    @PutMapping("/customers")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) throws CustomerNotFoundException {
        return bankAccountService.updateCustomer(customerDto);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCusteomer(@PathVariable Long id){
        bankAccountService.deleteCusteomer(id);
    }
}
