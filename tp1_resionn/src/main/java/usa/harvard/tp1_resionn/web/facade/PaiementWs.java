package usa.harvard.tp1_resionn.web.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_resionn.bean.Paiement;
import usa.harvard.tp1_resionn.service.facade.CommandeService1;
import usa.harvard.tp1_resionn.service.facade.PaimentService1;

import java.util.List;

@RestController
@RequestMapping("p")
public class PaiementWs {

    public void delete(Paiement entity) {
        paimentService1.delete(entity);
    }

    @GetMapping("/")
    public List<Paiement> findAll() {
        return paimentService1.findAll();
    }

    @PutMapping ("/encisser/{code}")
    public int encisser(@PathVariable String code) {
        return paimentService1.encisser(code);
    }

    public Paiement findByCode(String code) {
        return paimentService1.findByCode(code);
    }

    public int deleteByCode(String code) {
        return paimentService1.deleteByCode(code);
    }

    @PostMapping("/refCommande/{ref}")
    public int save(@PathVariable String refCommande,@RequestBody Paiement paiement) {
        return paimentService1.save(refCommande, paiement);
    }
    @Autowired
    private PaimentService1 paimentService1;
    @Autowired
    private CommandeService1 commandeService1;

}
