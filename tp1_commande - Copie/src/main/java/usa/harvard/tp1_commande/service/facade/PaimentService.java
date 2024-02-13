package usa.harvard.tp1_commande.service.facade;

import org.springframework.web.bind.annotation.RequestBody;
import usa.harvard.tp1_commande.bean.Paiement;

import java.util.List;

public interface PaimentService {
    void delete(Paiement entity);

    List<Paiement> findAll();

    int  save(String refCommande, Paiement paiement);
    int encisser(String code);

    int saver(Paiement paiement);
    Paiement findByCode(String code);

    int deleteByCode(String code);
}
