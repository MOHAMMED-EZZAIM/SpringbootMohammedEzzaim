package usa.harvard.tp1_commande.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.service.impl.TypePaiementServiceImpl;

import java.util.List;

@RestController
@RequestMapping("t")
public class TypePaiementWs {
    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }

    @GetMapping("/")
    public List<TypePaiement> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TypePaiement typePaiement) {
        return service.save(typePaiement);
    }

    @GetMapping("/code/{code}")
    public TypePaiement findByCode(@PathVariable String code) {
        return service.findByCode(code);
    }

    @Autowired
    private TypePaiementServiceImpl service ;
}
