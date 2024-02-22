package com.example.commande.ws.converter;

import com.example.commande.bean.Commande;
import com.example.commande.ws.dto.CommandeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeConverter {

    public Commande toBean(CommandeDto dto) {
        Commande bean = new Commande();
        bean.setTotalPay(dto.getTotalPay());
        bean.setTotal(dto.getTotal());
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        return bean;
    }

    public List<Commande> toBean(List<CommandeDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public CommandeDto toDto(Commande bean) {
        CommandeDto dto = new CommandeDto();
        dto.setTotalPay(bean.getTotalPay());
        dto.setTotal(bean.getTotal());
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        return dto;
    }

    public List<CommandeDto> toDto(List<Commande> beans) {
        return beans.stream().map(e->toDto(e)).collect(Collectors.toList());
    }


}
