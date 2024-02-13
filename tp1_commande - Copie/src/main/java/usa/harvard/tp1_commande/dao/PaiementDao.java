package usa.harvard.tp1_commande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.bean.TypePaiement;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long> {
    int deleteByCode(String code);
    Paiement findByCode(String code);
    List<Paiement> findAll();
//    Paiement finByCommandeRef(String commandeRef);
//    Commande findByCommande(String ref);
    List<Paiement> findByCommandeRef(String ref);

}
