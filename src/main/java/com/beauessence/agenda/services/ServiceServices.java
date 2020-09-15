package com.beauessence.agenda.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauessence.agenda.models.ServiceModel;
import com.beauessence.agenda.repositories.ServiceRep;

@Service
public class ServiceServices {

	@Autowired
	private ServiceRep serviceRep;
	
	public List<ServiceModel> retrieveAllServices() {
		List<ServiceModel> list = null;

		list = (List<ServiceModel>) serviceRep.findAll();
		if(list.isEmpty())
			throw new EntityNotFoundException("No data found."); 
		
		return list;
	}
	
	public ServiceModel appendService(ServiceModel service) {
		return serviceRep.save(service);
	}
	
	public void removeService(ServiceModel service) {
		serviceRep.delete(service);
	}
	
	public ServiceModel updateService(ServiceModel service) {
		return serviceRep.save(service);
	}
}
