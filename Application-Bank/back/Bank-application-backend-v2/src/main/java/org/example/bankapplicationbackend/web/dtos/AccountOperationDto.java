package org.example.bankapplicationbackend.web.dtos;

import lombok.Data;
import org.example.bankapplicationbackend.enums.OperationType;
import java.util.Date;

@Data
public class AccountOperationDto {
    private Long id;
    private Date operarionDate;
    private  double amount;
    private OperationType type;
    private String description;
}
