package com.beauessence.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauessence.agenda.models.Sale;
import com.beauessence.agenda.services.SaleServices;

@RestController
@RequestMapping("sale")
public class SaleController {
	
	private SaleServices saleService;
	
	@Autowired
	public SaleController(SaleServices saleService) {
		this.saleService=saleService;
	}
	
	@GetMapping("/getSales")
	public ResponseEntity<List<Sale>> retrieveSales() {
		return new ResponseEntity<>(saleService.retrieveSales(), HttpStatus.OK);
	}
	
	@GetMapping("/salesByDate/{date}")
	public ResponseEntity<List<Sale>> retrieveSalesByDate(@PathVariable("date") String date){
		return new ResponseEntity<>(saleService.retrieveSalesByDate(date).get(), HttpStatus.OK);
	}
	
	@PostMapping("/addSale")
	public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
		return new ResponseEntity<>(saleService.appendSale(sale), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeSale")
	public ResponseEntity<String> removeSale(Sale sale) {
		saleService.removeSale(sale);
		return new ResponseEntity<>("id:"+sale.getIdSale(), HttpStatus.OK);
	}
	
	@PutMapping("/updateSale")
	public ResponseEntity<Sale> updateSale(Sale sale) {
		return new ResponseEntity<>(saleService.updateSale(sale), HttpStatus.OK);
	}

}
