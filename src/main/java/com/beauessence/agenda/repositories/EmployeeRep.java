package com.beauessence.agenda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beauessence.agenda.models.Employee;

@Repository
public interface EmployeeRep extends CrudRepository<Employee, Integer>{

}
