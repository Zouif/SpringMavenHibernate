package com.zouif.repository;
import com.zouif.model.Client;
import org.springframework.data.repository.CrudRepository;


public interface IClientRepository extends CrudRepository<Client, Long> {

}
