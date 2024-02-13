package usa.harvard.tp1_commande.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.service.facade.PaimentService;

import java.util.List;

@RestController
@RequestMapping("p")
public class PaiementWs {
    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }
    @GetMapping("/code/{code}")
    public Paiement findByCode(String code) {
        return service.findByCode(code);
    }

    @DeleteMapping
    public void delete(Paiement entity) {
        service.delete(entity);
    }
    @PostMapping("/save/ref/{ref}")
    public int save(@PathVariable String ref,@RequestBody Paiement paiement) {
        return service.save(ref, paiement);
    }
    @PutMapping ("/encisser/{code}")
    public int encisser(@PathVariable  String code) {
        return service.encisser(code);
    }
    @PostMapping("/")
    public int saver(@RequestBody Paiement paiement) {
        return service.saver(paiement);
    }
    @GetMapping("/")
    public List<Paiement> findAll() {
        return service.findAll();
    }
    @Autowired
    private PaimentService service ;
}
