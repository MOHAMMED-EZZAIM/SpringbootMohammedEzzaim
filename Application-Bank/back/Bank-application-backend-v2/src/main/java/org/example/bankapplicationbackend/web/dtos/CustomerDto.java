package org.example.bankapplicationbackend.web.dtos;
import lombok.Data;
@Data
public class CustomerDto extends  BankAccountDto{
    private Long id;
    private String name;
    private String email;
}
