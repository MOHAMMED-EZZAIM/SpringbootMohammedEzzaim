package usa.harvard.tp1_resionn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import usa.harvard.tp1_resionn.bean.Paiement;

import java.util.List;
@Component
public interface PaiementDao1 extends JpaRepository<Paiement,Long> {
    int deleteByCode(String code);
    Paiement findByCode(String code);
    List<Paiement> findByCommandeRef(String ref);

}
