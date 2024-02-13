package usa.harvard.tp1_resionn.service.facade;

import usa.harvard.tp1_resionn.bean.Paiement;

import java.util.List;

public interface PaimentService1 {
    void delete(Paiement entity);
    List<Paiement> findAll();
    int  save(String refCommande, Paiement paiement);
    int encisser(String code);
    Paiement findByCode(String code);
    int deleteByCode(String code);
}
