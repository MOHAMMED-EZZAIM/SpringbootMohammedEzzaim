package usa.harvard.tp1_resionn.web.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_resionn.bean.Commande;
import usa.harvard.tp1_resionn.service.facade.CommandeService1;

import java.util.List;

@RestController
@RequestMapping("/c")
public class CommandeWs {

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService1.findAll();
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable  String ref) {
        return commandeService1.deleteByRef(ref);
    }
    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService1.save(commande);
    }

    @GetMapping("/ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService1.findByRef(ref);
    }
    @GetMapping("/findNonPaye")
    public List<Commande> findNonPaye() {
        return commandeService1.findNonPaye();
    }
//    @PutMapping("/ref/{ref}")
//    public void update(@PathVariable String ref, @RequestBody Commande commande) {
//        commandeService1.update(ref,commande);
//    }
    @Autowired
    private CommandeService1 commandeService1;
}
