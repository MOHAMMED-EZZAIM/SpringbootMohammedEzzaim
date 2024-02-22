package com.example.commande.ws.facade;

import com.example.commande.bean.Commande;
import com.example.commande.service.CommandeService;
import com.example.commande.ws.converter.CommandeConverter;
import com.example.commande.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/commande")
public class CommandeProvided {

    @GetMapping("/ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande bean = service.findByRef(ref);
        CommandeDto dto = converter.toDto(bean);
        return dto;
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return service.deleteByRef(ref);
    }

    @GetMapping("/ref/{ref}/total/{total}")
    public List<CommandeDto> findByRefLikeAndTotalGreaterThan(@PathVariable String ref,@PathVariable double total) {
        List<Commande> beans = service.findByRefLikeAndTotalGreaterThan(ref, total);
        List<CommandeDto> dtos = converter.toDto(beans);
        return dtos;
    }


    @GetMapping("/")
    public List<Commande> findAll() {
        return service.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody CommandeDto dto) {
        Commande bean = converter.toBean(dto);
        return service.save(bean);
    }
    @PutMapping("payer/ref/{ref}/montant/{mt}")
    public int payer(@PathVariable String ref,@PathVariable double mt) {
        return service.payer(ref, mt);
    }

    @Autowired
    private CommandeService service;
    @Autowired
    private CommandeConverter converter;
}
