package com.beauessence.agenda.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beauessence.agenda.models.Sale;

@Repository
public interface SaleRep extends CrudRepository<Sale, Integer>{

	public Optional<List<Sale>> findBysaleDate(Date date);
}
