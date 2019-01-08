package com.zouif.services;

import com.zouif.model.Client;
import com.zouif.model.Comptecourant;
import com.zouif.model.Operation;
import com.zouif.repository.IClientRepository;
import com.zouif.repository.IComptecourantRepository;
import com.zouif.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;

@Service
public class ServicesFacade implements IServicesFacade {

    @Autowired
    IClientRepository iClientRepository;

    @Autowired
    IComptecourantRepository iComptecourantRepository;

    @Autowired
    IOperationRepository iOperationRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public void transfert(Comptecourant comptecourantDebiter, Comptecourant comptecourantCrediter, int montant) {

        int soldeADebiter = comptecourantDebiter.getSolde();
        int soldeACrediter = comptecourantCrediter.getSolde();
        soldeADebiter = soldeADebiter-montant;
        soldeACrediter = soldeACrediter+montant;

        comptecourantDebiter.setSolde(soldeADebiter);
        comptecourantCrediter.setSolde(soldeACrediter);

        this.iComptecourantRepository.save(comptecourantDebiter);
        this.iComptecourantRepository.save(comptecourantCrediter);
    }

    public void effectuerVirement(int montant, long idDestinataire, long idExpediteur) throws Exception {
        Comptecourant expediteur = debiter(montant, idExpediteur);
        Comptecourant destinataire = crediter(montant, idDestinataire);


        Operation operation = new Operation();
        operation.setCompteDestinataire(destinataire);
        operation.setCompteExpediteur(expediteur);
        operation.setDate(new Date());
        operation.setMontant(montant);

        iOperationRepository.save(operation);
    }

    private Comptecourant debiter(int montant, long idCompte) throws Exception {

        Comptecourant compteCourant = iComptecourantRepository.findById(idCompte).orElse(null);
        if(compteCourant == null){
            throw new Exception("404");
        } else if (compteCourant.getSolde() + compteCourant.getDecouvert() > montant){
            throw new Exception("403");
        }
        compteCourant.setSolde(compteCourant.getSolde()-montant);
        iComptecourantRepository.save(compteCourant);
        return compteCourant;
    }

    private Comptecourant crediter(int montant, long idCompte) throws Exception {

        Comptecourant compteCourant = iComptecourantRepository.findById(idCompte).orElse(null);
        if(compteCourant == null){
            throw new Exception("404");
        } else if (compteCourant.getSolde() + compteCourant.getDecouvert() > montant){
            throw new Exception("403");
        }
        compteCourant.setSolde(compteCourant.getSolde()+montant);
        iComptecourantRepository.save(compteCourant);
        return compteCourant;
    }
}
