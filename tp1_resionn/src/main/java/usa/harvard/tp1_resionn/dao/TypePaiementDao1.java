package usa.harvard.tp1_resionn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import usa.harvard.tp1_resionn.bean.TypePaiement;

@Component
public interface TypePaiementDao1 extends JpaRepository<TypePaiement,Long> {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);
}
