package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Long> {
}
