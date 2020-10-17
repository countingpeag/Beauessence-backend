package com.beauessence.agenda.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauessence.agenda.models.Sale;
import com.beauessence.agenda.repositories.SaleRep;

@Service
public class SaleServices {

	@Autowired
	private SaleRep saleRep;
	
	public List<Sale> retrieveSales() {
		return (List<Sale>) saleRep.findAll();
	}
	
	public Sale appendSale(Sale sale) {
		return saleRep.save(sale);
	}
	
	public void removeSale(Sale sale) {
		saleRep.delete(sale);
	}
	
	public Sale updateSale(Sale sale) {
		return saleRep.save(sale);
	}
	
	public Optional<List<Sale>> retrieveSalesByDate(String date){
		Optional<List<Sale>> sales = null;
		try {
			String dateFormat = "yyyy-MM-dd";
			Date saleDate = new SimpleDateFormat(dateFormat).parse(date);
			sales = saleRep.findBysaleDate(saleDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return sales;
	}
}
