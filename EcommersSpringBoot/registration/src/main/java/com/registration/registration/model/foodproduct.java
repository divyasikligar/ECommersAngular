package com.registration.registration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class foodproduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use auto-incrementing ID
	private int productID;
	
	
	@Lob
    @Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	private String productname;
	private double price;
	private String description;
	private String sectionid;
	
	public foodproduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public foodproduct(int productID, byte[] image, String productname, double price, String description,
			String sectionid) {
		super();
		this.productID = productID;
		this.image = image;
		this.productname = productname;
		this.price = price;
		this.description = description;
		this.sectionid = sectionid;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSectionid() {
		return sectionid;
	}

	public void setSectionid(String sectionid) {
		this.sectionid = sectionid;
	}

	

	
	
	
}
