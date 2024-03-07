package org.example.bankapplicationbackend.web.converter;

import org.example.bankapplicationbackend.bean.AccountOperation;
import org.example.bankapplicationbackend.web.dtos.AccountOperationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

public class AccountOperationConverter {
    public AccountOperation toBean(AccountOperationDto currentAcountDto){
        AccountOperation currentAcount=new AccountOperation();
        BeanUtils.copyProperties(currentAcountDto, currentAcount);
        return currentAcount;
    }
    public AccountOperationDto toDto(AccountOperation currentAcount){
        AccountOperationDto currentAcountDto =new AccountOperationDto();
        BeanUtils.copyProperties(currentAcount, currentAcountDto);
        return currentAcountDto;
    }
}
