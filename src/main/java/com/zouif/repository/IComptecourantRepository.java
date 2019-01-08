package com.zouif.repository;

import com.zouif.model.Comptecourant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IComptecourantRepository extends CrudRepository<Comptecourant, Long> {

    @Query( value="SELECT * FROM Comptecourant b JOIN Client a ON b.id_client= a.id WHERE a.id = ?1 AND b.solde > ?2",
            nativeQuery = true)
    List<Comptecourant> afficherClientCond(int idClient, int montantSolde);

}
