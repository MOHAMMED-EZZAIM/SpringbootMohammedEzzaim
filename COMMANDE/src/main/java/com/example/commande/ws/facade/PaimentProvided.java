package com.example.commande.ws.facade;

import com.example.commande.bean.Paiement;
import com.example.commande.service.PaiementService;
import com.example.commande.ws.converter.PaiementConverter;
import com.example.commande.ws.dto.PaiementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paiement")
public class PaimentProvided {

    @GetMapping("/code/{code}")
    public PaiementDto findByCode(@PathVariable String code) {
        Paiement bean = service.findByCode(code);
        PaiementDto dto = converter.toDto(bean);
        return dto;
    }
    @GetMapping("/commande/ref/{ref}")
    public List<PaiementDto> findByCommandeRef(@PathVariable String ref) {
        List<Paiement> beans = service.findByCommandeRef(ref);
        List<PaiementDto> dtos = converter.toDto(beans);
        return dtos;
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }


    @GetMapping("/")
    public List<Paiement> findAll() {
        return service.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody PaiementDto dto) {
        Paiement bean = converter.toBean(dto);
        return service.save(bean);
    }
   

    @Autowired
    private PaiementService service;
    @Autowired
    private PaiementConverter converter;
}
