package com.example.commande.service;

import com.example.commande.bean.Commande;
import com.example.commande.dao.CommandeDao;
import com.example.commande.dao.PaiementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CommandeService {
    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        int res1 = paiementDao.deleteByCommandeRef(ref);
        int res2 = commandeDao.deleteByRef(ref);
        return res1 + res2;
    }


    public List<Commande> findByRefLikeAndTotalGreaterThan(String ref, double total) {
        return commandeDao.findByRefLikeAndTotalGreaterThan(ref, total);
    }

    @Deprecated
    public Commande getOne(Long aLong) {
        return commandeDao.getOne(aLong);
    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else if (commande.getTotal() < commande.getTotalPay()) {
            return -2;
        } else {
            commandeDao.save(commande);
            return 1;
        }
    }

    public int payer(String ref, double mt) {
        Commande commande = findByRef(ref);
        if (commande == null) {
            return -1;
        } else if (commande.getTotalPay() + mt > commande.getTotal()) {
            return -2;
        } else {
            double nvTotalPaye = commande.getTotalPay() + mt;
            commande.setTotalPay(nvTotalPaye);
            commandeDao.save(commande);
            return 1;
        }


    }

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private PaiementDao paiementDao;

}
