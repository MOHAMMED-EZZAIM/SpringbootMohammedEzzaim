package org.example.bankapplicationbackend.web.converter;
import org.example.bankapplicationbackend.bean.CurrentAcount;
import org.example.bankapplicationbackend.bean.Customer;
import org.example.bankapplicationbackend.web.dtos.CurrentAcountDto;
import org.example.bankapplicationbackend.web.dtos.CustomerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CurrentAcountConverter {
    public CurrentAcount toBean(CurrentAcountDto currentAcountDto){
        CurrentAcount currentAcount=new CurrentAcount();
        BeanUtils.copyProperties(currentAcountDto, currentAcount);
        return currentAcount;
    }
    public CurrentAcountDto toDto(CurrentAcount currentAcount){
        CurrentAcountDto currentAcountDto =new CurrentAcountDto();
        BeanUtils.copyProperties(currentAcount, currentAcountDto);
        currentAcountDto.setType(currentAcount.getClass().getSimpleName());
        return currentAcountDto;
    }
}
