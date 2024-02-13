package usa.harvard.tp1_commande.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import usa.harvard.tp1_commande.bean.Commande;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {
    int deleteByRef (String ref);
    Commande findByRef (String ref);
    List<Commande> findAll();

//    @Query("SELECT ITME FROM Commande where ITME.total<ITME. "
@Query(
        value = "SELECT c.* FROM Commande c,Paiement p where(p.commande_id like c.id) and (c.montant_paye_espece+c.montant_paye_cheque+p.montant<  c.montant_Total)",
        nativeQuery = true)
    List<Commande> findNonPaye();
}
//ref commande ..... la list des paiment  de cette commande