package com.maintenance.entity;


public class BookingDetail implements java.io.Serializable {

	private BookingDetailId id = new BookingDetailId();
	private Services services;
	private ServicesBooking servicesBooking;
	private int quantity;
	private float subtotal;	

	public BookingDetail() {
	}

	public BookingDetail(BookingDetailId id) {
		this.id = id;
	}

	public BookingDetail(BookingDetailId id, Services services, ServicesBooking servicesBooking, int quantity, float subtotal) {
		this.id = id;
		this.services = services;
		this.servicesBooking = servicesBooking;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public BookingDetailId getId() {
		return id;
	}

	public void setId(BookingDetailId id) {
		this.id = id;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	
}
