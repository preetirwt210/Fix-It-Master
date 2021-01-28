package com.maintenance.entity;
// Generated May 22, 2018 5:46:15 AM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;




public class ServicesBooking implements java.io.Serializable {

	private Integer bookingId;
	private Customer customer;
	private Date bookingDate;
	private String recipientAddress;
	private String recipientName;
	private String recipientPhone;
	private String paymentMethod;
	private float total;
	private String status;
	private Set<BookingDetail> bookingDetails = new HashSet<BookingDetail>(0);

	public ServicesBooking() {
	}
 
	public ServicesBooking(Integer bookingId, Customer customer, Date bookingDate, String recipientAddress,
			String recipientName, String recipientPhone, String paymentMethod, float total, String status,
			Set<BookingDetail> bookingDetails) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.bookingDate = bookingDate;
		this.recipientAddress = recipientAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
		this.bookingDetails = bookingDetails;
	}

	public ServicesBooking(Customer customer, Date bookingDate, String recipientAddress, String recipientName,
			String recipientPhone, String paymentMethod, float total, String status) {
		this.customer = customer;
		this.bookingDate = bookingDate;
		this.recipientAddress = recipientAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
	}

	public ServicesBooking(Customer customer, Date bookingDate, String recipientAddress, String recipientName,
			String recipientPhone, String paymentMethod, float total, String status, Set<BookingDetail> bookingDetails) {
		this.customer = customer;
		this.bookingDate = bookingDate;
		this.recipientAddress = recipientAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
		this.bookingDetails = bookingDetails;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<BookingDetail> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(Set<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	@Override
	public String toString() {
		return "ServicesBooking [bookingId=" + bookingId + ", customer=" + customer + ", bookingDate=" + bookingDate
				+ ", recipientAddress=" + recipientAddress + ", recipientName=" + recipientName + ", recipientPhone="
				+ recipientPhone + ", paymentMethod=" + paymentMethod + ", total=" + total + ", status=" + status
				+ ", bookingDetails=" + bookingDetails + "]";
	}

		
}
