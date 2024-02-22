package com.example.commande.ws.converter;

import com.example.commande.bean.Paiement;
import com.example.commande.ws.dto.PaiementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaiementConverter {

    public Paiement toBean(PaiementDto dto) {
        Paiement bean = new Paiement();
        BeanUtils.copyProperties(dto, bean);
        return bean;
    }

    public List<Paiement> toBean(List<PaiementDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public PaiementDto toDto(Paiement bean) {
        PaiementDto dto = new PaiementDto();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }

    public List<PaiementDto> toDto(List<Paiement> beans) {
        return beans.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }


}
