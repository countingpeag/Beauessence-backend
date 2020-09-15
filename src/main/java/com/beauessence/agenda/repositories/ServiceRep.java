package com.beauessence.agenda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beauessence.agenda.models.ServiceModel;

@Repository
public interface ServiceRep extends CrudRepository<ServiceModel, Integer>{

}
