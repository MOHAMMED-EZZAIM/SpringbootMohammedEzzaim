package usa.harvard.tp1_resionn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.harvard.tp1_resionn.bean.TypePaiement;
import usa.harvard.tp1_resionn.dao.TypePaiementDao1;
import usa.harvard.tp1_resionn.service.facade.TypePaimentService1;
@Service
public class TypePaimentImpl implements TypePaimentService1 {
    @Autowired
    TypePaiementDao1 typePaiementDao1;
    @Override
    public int deleteByCode(String code) {
        return typePaiementDao1.deleteByCode(code);
    }

    @Override
    public TypePaiement findByCode(String code) {
        return typePaiementDao1.findByCode(code);
    }
}
