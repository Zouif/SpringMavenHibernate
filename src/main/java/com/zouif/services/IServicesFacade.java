package com.zouif.services;

import com.zouif.model.Client;
import com.zouif.model.Comptecourant;

import java.util.List;

public interface IServicesFacade {

    void transfert(Comptecourant comptecourantDebiter, Comptecourant comptecourantCrediter, int montant);

    void effectuerVirement(int montant, long idDestinataire, long idExpediteur) throws Exception;
}
