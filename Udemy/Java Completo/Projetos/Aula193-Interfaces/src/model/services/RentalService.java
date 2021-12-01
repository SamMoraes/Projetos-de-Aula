package model.services;

import model.entities.CarRental;

public class RentalService {

	private Double pricePerDay;
	private Double pricePeHour;
	
	private BrazilTaxServices taxService;
	
	public RentalService() {
		
	}

	public RentalService(Double pricePerDay, Double pricePeHour, BrazilTaxServices taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePeHour = pricePeHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental){
		
	}
	
	
}
