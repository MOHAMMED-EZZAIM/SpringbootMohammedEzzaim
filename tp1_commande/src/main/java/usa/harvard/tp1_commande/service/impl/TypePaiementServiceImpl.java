package usa.harvard.tp1_commande.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.dao.TypePaiementDao;

import java.util.List;

@Service
    public class TypePaiementServiceImpl extends TypePaiement {
        public TypePaiement findByCode(String code) {
            return dao.findByCode(code);
        }
        public int save( TypePaiement typePaiement) {
             dao.save(typePaiement);
             return 1;
        }
        public int deleteByCode(String code) {
            return dao.deleteByCode(code);
        }
    public List<TypePaiement> findAll() {
        return dao.findAll();
    }
        @Autowired
        private TypePaiementDao dao;
    }

