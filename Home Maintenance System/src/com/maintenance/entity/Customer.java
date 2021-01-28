package com.maintenance.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class Customer implements java.io.Serializable {

	private Integer customerId;
	private String email;
	private String fullname;
	private String address;
	private String city;
	private String country;
	private String phone;
	private String zipcode;
	private String password;
	private Date registerDate;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<ServicesBooking> servicesBooking = new HashSet<ServicesBooking>(0);

	public Customer() {
	}

	public Customer(String email, String fullname, String address, String city, String country, String phone,
			String zipcode, String password, Date registerDate) {
		this.email = email;
		this.fullname = fullname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.zipcode = zipcode;
		this.password = password;
		this.registerDate = registerDate;
	}

	public Customer(String email, String fullname, String address, String city, String country, String phone,
			String zipcode, String password, Date registerDate, Set<Review> reviews, Set<ServicesBooking> servicesBooking) {
		this.email = email;
		this.fullname = fullname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.zipcode = zipcode;
		this.password = password;
		this.registerDate = registerDate;
		this.reviews = reviews;
		this.servicesBooking = servicesBooking;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<ServicesBooking> getServicesBooking() {
		return servicesBooking;
	}

	public void setServicesBooking(Set<ServicesBooking> servicesBooking) {
		this.servicesBooking = servicesBooking;
	}

	
}
