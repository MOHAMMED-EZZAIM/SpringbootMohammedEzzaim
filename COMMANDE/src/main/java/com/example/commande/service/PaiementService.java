package com.example.commande.service;

import com.example.commande.bean.Commande;
import com.example.commande.bean.Paiement;
import com.example.commande.dao.CommandeDao;
import com.example.commande.dao.PaiementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaiementService {
    public Paiement findByCode(String code) {
        return paiementDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return paiementDao.deleteByCode(code);
    }


    @Deprecated
    public Paiement getOne(Long aLong) {
        return paiementDao.getOne(aLong);
    }

    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

    public int save(Paiement paiement) {
        Commande commande = commandeDao.findByRef(paiement.getCommande().getRef());
        paiement.setCommande(commande);
        if (commande == null) {
            return -1;
        } else if (findByCode(paiement.getCode()) != null) {
            return -2;
        } else {
            paiementDao.save(paiement);
            return 1;
        }
    }

    public int deleteByCommandeRef(String ref) {
        return paiementDao.deleteByCommandeRef(ref);
    }

    public List<Paiement> findByCommandeRef(String ref) {
        return paiementDao.findByCommandeRef(ref);
    }

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private PaiementDao paiementDao;

}
