package org.example.bankapplicationbackend.web.dtos;
import lombok.Data;
import org.example.bankapplicationbackend.enums.AcountStatus;
import java.util.Date;
@Data
public class CurrentAcountDto extends BankAccountDto{
    private String id;
    private double balance;
    private Date createdAt;
    private AcountStatus status;
    private  CustomerDto customerDto;
    private  double overDraft;
}
