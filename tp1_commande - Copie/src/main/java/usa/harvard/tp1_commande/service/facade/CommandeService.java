package usa.harvard.tp1_commande.service.facade;

import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;

import java.util.List;

public interface CommandeService {
    List<Commande> findAll();

    int deleteByRef(String ref);

    int  save(Commande commande);

    Commande findByRef(String ref);

    List<Commande> findNonPaye();
    void update(String ref, Commande commande);

}
