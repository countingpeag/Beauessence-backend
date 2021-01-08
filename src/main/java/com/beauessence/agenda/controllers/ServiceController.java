package com.beauessence.agenda.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauessence.agenda.models.ServiceModel;
import com.beauessence.agenda.services.ServiceServices;

@RestController
@RequestMapping("service")
public class ServiceController {
	
	private ServiceServices serviceServices;
	
	@Autowired
	public ServiceController(ServiceServices serviceServices) {
		this.serviceServices=serviceServices;
	}
	
	@GetMapping("getServices")
	public ResponseEntity<List<ServiceModel>> getServices(){
		return new ResponseEntity<>(serviceServices.retrieveAllServices(), HttpStatus.OK);
	}
	
	@PostMapping("/addService")
	public ResponseEntity<ServiceModel> addService(@Valid @RequestBody ServiceModel service, BindingResult br) {
		return new ResponseEntity<>(serviceServices.appendService(service), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeService")
	public ResponseEntity<String> removeService(@Valid @RequestBody ServiceModel service, BindingResult br) {
		serviceServices.removeService(service);
		return new ResponseEntity<>("Id:"+service.getIdService(), HttpStatus.OK);
	}
	
	@PutMapping("/updateService")
	public ResponseEntity<ServiceModel> updateService(@Valid @RequestBody ServiceModel Service, BindingResult br) {
		return new ResponseEntity<>(serviceServices.updateService(Service), HttpStatus.OK);
	}
}
