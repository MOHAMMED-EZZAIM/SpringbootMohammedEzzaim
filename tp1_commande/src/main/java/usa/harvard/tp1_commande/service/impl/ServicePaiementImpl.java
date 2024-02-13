package usa.harvard.tp1_commande.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.dao.CommandeDao;
import usa.harvard.tp1_commande.dao.PaiementDao;
import usa.harvard.tp1_commande.dao.TypePaiementDao;
import usa.harvard.tp1_commande.service.facade.CommandeService;
import usa.harvard.tp1_commande.service.facade.PaimentService;

import java.util.List;

@Service
public class ServicePaiementImpl  implements PaimentService {
    public static final String ESPECE = "espece";
    public static final String CHEQUE = "cheque";

    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    public Paiement findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    public void delete(Paiement entity) {
        dao.delete(entity);
    }


    public List<Paiement> findAll() {
        return dao.findAll();
    }

    private @Autowired PaiementDao dao;
    private @Autowired  CommandeService commandeService;
    private  @Autowired CommandeDao commandeDao;
    private @Autowired TypePaiementServiceImpl typePaiementService;

    @Override
    public int save(String refCommande, Paiement paiement) {
        String code=paiement.getTypePaiement().getCode();
        TypePaiement typePaiement =typePaiementService.findByCode(code);
        paiement.setTypePaiement(typePaiement);
        Commande commande = commandeDao.findByRef(refCommande);

        if (commande == null) {
            return -1;
        } else if (commande.getMontantPayeEspece() + commande.getMontantPayeCheque() + paiement.getMontant() > commande.getMontantTotal()) {
            return -2;
        } else if ((paiement.getTypePaiement() == null)||(paiement.getTypePaiement() != null &&
                !paiement.getTypePaiement().getCode().equals(ESPECE) &&
                !paiement.getTypePaiement().getCode().equals(CHEQUE))) {
            return -3;
        } else {
            dao.save(paiement);
            String codeTypePaiment = paiement.getTypePaiement().getCode();
            if (ESPECE.equals(codeTypePaiment)) {
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiement.getMontant());

            } else {
                commande.setMontantPayeCheque(commande.getMontantPayeCheque() + paiement.getMontant());
            }
            commandeService.update(commande.getRef(),commande);
                return 1;
        }
    }
    @Override
    public int encisser(String code){
        Paiement paiement=findByCode(code);
        if(paiement==null){
            return  -1;
        }
        else if (paiement.getTypePaiement().getCode()!=null&&
                !paiement.getTypePaiement().getCode().equals(CHEQUE)){
            return  -2;
        } else if (paiement.isEncaissement()==true) {
            return -3;
        }else {
            paiement.setEncaissement(true);
            dao.save(paiement);
            //ager tayjib like commande kamlma
            Commande commande=paiement.getCommande();
            commande.setMontantPayeCheque(commande.getMontantPayeCheque()-paiement.getMontant());
            commande.setMontantPayeEspece(commande.getMontantPayeEspece()-paiement.getMontant());
            commandeService.update(commande.getRef(),commande);
            return 1;
        }
    }
    @Override
    public int saver( Paiement paiement) {
        Paiement p1=findByCode(paiement.getCode());
        if(p1!=null){
            return -1;
        } else {
            dao.save(p1);
            return 1;
        }
    }
//    Paiement finByCommandeRef(String ref){
//        if(commandeDao.findByRef(ref)==null){
//                return  null;
//        } else if () {
//
//        }
//    }
//    @Autowired
//    CommandeDao commandeDao;
}