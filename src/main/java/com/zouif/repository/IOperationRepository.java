package com.zouif.repository;

import com.zouif.model.Client;
import com.zouif.model.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOperationRepository extends CrudRepository<Operation, Long> {


}
