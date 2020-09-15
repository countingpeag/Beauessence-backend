package com.beauessence.agenda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beauessence.agenda.models.Customer;

@Repository
public interface CustomerRep extends CrudRepository<Customer, Integer>{
}
