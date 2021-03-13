package com.maintenance.entity;

public class BookingDetailId implements java.io.Serializable {

	private Services services;
	private ServicesBooking servicesBooking;
	
	public BookingDetailId() {
	}

	
	public BookingDetailId(Services services, ServicesBooking servicesBooking) {
		super();
		this.services = services;
		this.servicesBooking = servicesBooking;
	}


	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public ServicesBooking getServicesBooking() {
		return servicesBooking;
	}

	public void setServicesBooking(ServicesBooking servicesBooking) {
		this.servicesBooking = servicesBooking;
	}


		

}
