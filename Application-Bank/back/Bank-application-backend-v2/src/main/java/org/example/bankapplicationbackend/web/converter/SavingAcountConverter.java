package org.example.bankapplicationbackend.web.converter;

import org.example.bankapplicationbackend.bean.SavingAcount;
import org.example.bankapplicationbackend.web.dtos.CustomerDto;
import org.example.bankapplicationbackend.web.dtos.SavingAcountDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingAcountConverter {
    public SavingAcount toBean(SavingAcountDto savingAcountDto){
        SavingAcount savingAcount=new SavingAcount();
        BeanUtils.copyProperties(savingAcountDto, savingAcount);
        return savingAcount;
    }
    public SavingAcountDto toDto(SavingAcount savingAcount){
        SavingAcountDto savingAcountDto =new SavingAcountDto();
        BeanUtils.copyProperties(savingAcount, savingAcountDto);
        savingAcountDto.setType(savingAcount.getClass().getSimpleName());
        return savingAcountDto;
    }
}

