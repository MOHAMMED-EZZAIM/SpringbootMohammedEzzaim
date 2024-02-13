package usa.harvard.tp1_commande.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.dao.CommandeDao;
import usa.harvard.tp1_commande.service.facade.CommandeService;

import java.util.List;
@Service
public class ServiceCommandeImpl  implements CommandeService {
    private @Autowired CommandeDao dao;
    @Transactional
    public int deleteByRef(String ref) {
        return dao.deleteByRef(ref);
    }
    public List<Commande> findAll() {
        return dao.findAll();
    }
    public int save(Commande commande) {
        if(findByRef(commande.getRef())!=null){
            return  -1;
        } else if (commande.getMontantPayeEspece() +
                   commande.getMontantPayeCheque()>commande.getMontantTotal()
        ) {
            return -2;
        }
        dao.save(commande);
         return 1;
    }

    public Commande findByRef(String ref) {
        return dao.findByRef(ref);
    }

    public List<Commande> findNonPaye() {
        return dao.findNonPaye();
    }
    @Override
    public void update(String ref, Commande commande) {
        Commande commande1=dao.findByRef(ref);
        commande1=commande;
        dao.save(commande1);
    }


}
