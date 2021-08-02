package com.maintenance.entity;
 
import java.util.HashSet;
import java.util.Set;



public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String name;
	private byte[] image;
	private String base64Image;
	private Set<Services> services = new HashSet<Services>(0);

	public Category() {}

	public Category(Integer categoryId, String name, byte[] image, String base64Image, Set<Services> services) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.image = image;
		this.base64Image = base64Image;
		this.services = services;
	}

	public Category(String name, byte[] image, String base64Image, Set<Services> services) {
		super();
		this.name = name;
		this.image = image;
		this.base64Image = base64Image;
		this.services = services;
	}



	public Category(Integer categoryId2, String name2, String image2) {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name2) {
		// TODO Auto-generated constructor stub
	}

	public String getBase64Image() {
		return base64Image;
	}


	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}


	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<Services> getServices() {
		return services;
	}

	public void setServices(Set<Services> services) {
		this.services = services;
	}

	
}
