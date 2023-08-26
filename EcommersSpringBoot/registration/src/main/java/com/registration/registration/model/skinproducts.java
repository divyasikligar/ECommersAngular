package com.registration.registration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Table
@Entity
public class skinproducts  {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use auto-incrementing ID
	private int productID;
    
    @Column(name = "productname")
	private String productname;
    
    
	@Lob
    @Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@Column
	private double price;
	
	@Column(name = "sectionid")
	private String sectionid;
	
	
	public skinproducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public skinproducts(int productID, String productname, byte[] image, double price, String sectionid) {
		super();
		this.productID = productID;
		this.productname = productname;
		this.image = image;
		this.price = price;
		this.sectionid = sectionid;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSectionid() {
		return sectionid;
	}
	public void setSectionid(String sectionid) {
		this.sectionid = sectionid;
	}
	
	 

}
