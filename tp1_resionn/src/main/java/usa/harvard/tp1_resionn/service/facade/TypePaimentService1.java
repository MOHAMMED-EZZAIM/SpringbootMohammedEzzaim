package usa.harvard.tp1_resionn.service.facade;
import usa.harvard.tp1_resionn.bean.TypePaiement;

public interface TypePaimentService1 {
    int deleteByCode(String code);
    TypePaiement findByCode(String code);
}
