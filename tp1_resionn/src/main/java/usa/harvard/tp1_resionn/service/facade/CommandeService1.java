package usa.harvard.tp1_resionn.service.facade;

import usa.harvard.tp1_resionn.bean.Commande;

import java.util.List;

public interface CommandeService1 {   List<Commande> findAll();
    int deleteByRef(String ref);
    int  save(Commande commande);
    Commande findByRef(String ref);
    List<Commande> findNonPaye();
    void update(String ref, Commande commande);

}

