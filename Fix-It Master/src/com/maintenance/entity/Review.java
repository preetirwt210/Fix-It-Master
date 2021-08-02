package com.maintenance.entity;
// Generated May 22, 2018 5:46:15 AM by Hibernate Tools 5.2.10.Final


import java.util.Date;

public class Review implements java.io.Serializable {

	private Integer reviewId;
	private Services services;
	private Customer customer;
	private int rating;
	private String headline;
	private String comment;
	private Date reviewTime;

	public Review() {
	}

	public Review(Services services, Customer customer, int rating, String headline, String comment, Date reviewTime) {
		this.services = services;
		this.customer = customer;
		this.rating = rating;
		this.headline = headline;
		this.comment = comment;
		this.reviewTime = reviewTime;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	}
