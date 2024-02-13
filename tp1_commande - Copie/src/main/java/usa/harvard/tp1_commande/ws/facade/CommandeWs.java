package usa.harvard.tp1_commande.ws.facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.service.facade.CommandeService;
import usa.harvard.tp1_commande.service.impl.ServiceCommandeImpl;
import java.util.List;

@RestController
@RequestMapping("c")
public class CommandeWs {
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return commandeService.deleteByRef(ref);
    }
    @GetMapping("/ref2/{ref}")
    public Commande findByRef( @PathVariable String ref) {
        return commandeService.findByRef(ref);
    }
    @GetMapping("/findNon")
    public List<Commande> findNonPaye() {
        return commandeService.findNonPaye();
    }
    @PutMapping("/UpdateMethode/ref/{ref}")
    public void update(@PathVariable String ref,@RequestBody Commande commande) {
        commandeService.update(ref,commande);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody  Commande commande) {
        return commandeService.save(commande);
    }
    @Autowired
    CommandeService commandeService;
}
