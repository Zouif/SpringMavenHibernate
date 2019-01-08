package com.zouif.controller;

import com.zouif.model.Comptecourant;
import com.zouif.repository.IComptecourantRepository;
import com.zouif.repository.IOperationRepository;
import com.zouif.services.IServicesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zouif.repository.IClientRepository;
import com.zouif.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private IClientRepository iclientRepository;

    @Autowired
    private IComptecourantRepository iComptecourantRepository;

    @Autowired
    private IServicesFacade iServicesFacade;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/clients")
    public List<Client> retrieveAllClients() {
        return (List) iclientRepository.findAll();
    }

    @GetMapping("/comptecourant")
    public List<Comptecourant> retrieveCompteCourants() {
        return (List) iclientRepository.findAll();
    }

    @PostMapping("/ajoutCLient")
    public String ajoutClient(String nom, String prenom){
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        iclientRepository.save(client);
        return "AAjout du client effectué";
    }

    @PostMapping("/virement")
    public void virement(int montant, long idExpediteur, long idDestinataire) {
        this.iServicesFacade.effectuerVirement(montant, idExpediteur, idDestinataire);
    }

    @PostMapping("/clientCond")
    public List<Comptecourant> afficherClientCond(int idCompte, int montant) {
        return this.iComptecourantRepository.afficherClientCond(idCompte, montant);
    }
}