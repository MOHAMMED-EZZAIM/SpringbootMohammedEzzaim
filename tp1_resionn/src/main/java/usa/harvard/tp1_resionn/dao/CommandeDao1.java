package usa.harvard.tp1_resionn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import usa.harvard.tp1_resionn.bean.Commande;

import java.util.List;
@Component
public interface CommandeDao1 extends JpaRepository<Commande,Long> {
    int deleteByRef(String ref);
    Commande findByRef(String ref);

@Query(value = "SELECT c.* FROM Commande c,Paiement p where(p.commande_id like c.id) and (c.montant_paye_espece+c.montant_paye_cheque+p.montant<  c.montant_Total)",
        nativeQuery = true)
List<Commande> findNonPaye();

}
