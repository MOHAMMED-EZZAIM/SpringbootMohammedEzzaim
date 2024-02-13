package usa.harvard.tp1_resionn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.harvard.tp1_resionn.bean.Commande;
import usa.harvard.tp1_resionn.dao.CommandeDao1;
import usa.harvard.tp1_resionn.service.facade.CommandeService1;
import java.util.List;
@Service
public class ServiceComanImp1 implements CommandeService1 {
    @Autowired
    private CommandeDao1 commandeDao;
    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
    @Override
    public int deleteByRef(String ref) {
        return commandeDao.deleteByRef(ref);
    }
    @Override
    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }
    @Override
    public int save(Commande commande) {
        if(findByRef(commande.getRef())!=null){
            return  -1;
        } else if (commande.getMontantPayeEspece()+commande.getMontantPayeCheque()>commande.getMontantTotal()) {
            return -2;
        }else{
            commandeDao.save(commande);
            return 1;
        }
    }
    @Override
    public List<Commande> findNonPaye() {
        return commandeDao.findAll();
    }
    @Override
//    public int update(String ref, Commande commande) {
//        Commande commande1=findByRef(ref);
//        if(commande1==null){
//            return -1;
//        }else{
//            commande1.setMontantPayeCheque(commande.getMontantPayeCheque());
//            commande1.setMontantPayeEspece(commande.getMontantPayeEspece());
//            commande1.setMontantTotal(commande.getMontantTotal());
//            commande1.setPaiement(commande.getPaiement());
//            commandeDao.save(commande1);
//            return 1;
//        }
//    }
    public void update(String ref, Commande commande) {
        Commande commande1=commandeDao.findByRef(ref);
        commande1=commande;
        commandeDao.save(commande1);

    }
}
