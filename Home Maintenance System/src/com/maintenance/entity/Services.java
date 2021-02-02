package com.maintenance.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Services implements java.io.Serializable {

	private Integer serviceId;
	private Category category;
	private String title;
	private String description;
	private byte[] image;
	private String base64Image;
	private float price;
	private Date lastUpdateTime;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<BookingDetail> bookingDetails = new HashSet<BookingDetail>(0);

	public Services() {
	}
	
	public Services(Integer serviceId) {
		super();
		this.serviceId = serviceId;
	}



	public Services(Integer serviceId, Category category, String title, String description, byte[] image,
			String base64Image, float price, Date lastUpdateTime, Set<Review> reviews,
			Set<BookingDetail> bookingDetails,String categoryName) {
		super();
		this.serviceId = serviceId;
		this.category = category;
		this.title = title;
		this.description = description;
		this.image = image;
		this.base64Image = base64Image;
		this.price = price;
		this.lastUpdateTime = lastUpdateTime;
		this.reviews = reviews;
		this.bookingDetails = bookingDetails;
	}

	public Services(Category category, String title,  String description,  byte[] image,
			float price, Date lastUpdateTime) {
		this.category = category;
		this.title = title;
		this.description = description;
		this.image = image;
		this.price = price;
		this.lastUpdateTime = lastUpdateTime;
	}

	public Services(Category category, String title,  String description, byte[] image,
			float price,  Date lastUpdateTime, Set<Review> reviews, Set<BookingDetail> bookingDetails) {
		this.category = category;
		this.title = title;
		this.description = description;
		this.image = image;
		this.price = price;
		this.lastUpdateTime = lastUpdateTime;
		this.reviews = reviews;
		this.bookingDetails = bookingDetails;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<BookingDetail> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(Set<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	
	
	
	}
