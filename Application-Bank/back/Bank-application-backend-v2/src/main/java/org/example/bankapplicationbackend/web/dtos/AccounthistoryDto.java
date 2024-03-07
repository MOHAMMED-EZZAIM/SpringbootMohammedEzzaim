package org.example.bankapplicationbackend.web.dtos;

import lombok.Data;

import java.util.List;
@Data
public class AccounthistoryDto {
    private String accounId;
    private double balance;
    private int currentPages;
    private int totalPages;
    private int pageSize;
    private List<AccountOperationDto> accounthistoryDtoList;
}
