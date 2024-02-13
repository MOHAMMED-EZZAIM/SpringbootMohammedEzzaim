package usa.harvard.tp1_resionn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.harvard.tp1_resionn.bean.Commande;
import usa.harvard.tp1_resionn.bean.Paiement;
import usa.harvard.tp1_resionn.bean.TypePaiement;
import usa.harvard.tp1_resionn.dao.PaiementDao1;
import usa.harvard.tp1_resionn.service.facade.PaimentService1;

import java.util.List;

@Service
public class ServicePaimentImpl1 implements PaimentService1 {
    private static final String  CHEQUE="cheque";
    private static  final String ESPECE="espece";
    @Autowired
    private PaiementDao1 paiementDao1;
    @Autowired
    private ServiceComanImp1 serviceComanImp1;
    @Autowired
    private TypePaimentImpl typePaiment;
    public void delete(Paiement entity) {
    }
    public List<Paiement> findAll() {
        return paiementDao1.findAll();
    }

    public int save(String refCommande, Paiement paiement) {
        Commande commande=serviceComanImp1.findByRef(refCommande);
        String code =paiement.getTypePaiement().getCode();
        TypePaiement typePaiement=typePaiment.findByCode(code);

        if(commande==null){
            return -1;
        } else if (commande.getMontantPayeEspece()
                +commande.getMontantPayeCheque()
                +paiement.getMontant()>commande.getMontantTotal()){
            return -2;

        } else if ((typePaiement==null )||(typePaiement!=null && (!CHEQUE.equals(code) && !ESPECE.equals(code)))) {
            return  -3;
        }else {
            paiementDao1.save(paiement);
            if(ESPECE.equals(code)){
                commande.setMontantPayeEspece(commande.getMontantPayeEspece()+paiement.getMontant());
            }
            if(CHEQUE.equals(code)){
                commande.setMontantPayeCheque(commande.getMontantPayeCheque()+paiement.getMontant());
            }
            serviceComanImp1.update(commande.getRef(),commande);
            return 1;
        }
    }

    public int encisser(String code) {
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
            paiementDao1.save(paiement);
            //ager tayjib like commande kamlma
            Commande commande=paiement.getCommande();
            commande.setMontantPayeCheque(commande.getMontantPayeCheque()-paiement.getMontant());
            commande.setMontantPayeEspece(commande.getMontantPayeEspece()-paiement.getMontant());
            serviceComanImp1.update(commande.getRef(),commande);
            return 1;
        }
    }
    public Paiement findByCode(String code) {
        return null;
    }

    public int deleteByCode(String code) {
        return 0;
    }
}
