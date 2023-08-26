package com.registration.registration.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class cartdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use auto-incrementing ID
	private int cartID;
	private int productID;
	
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;
	
	@Lob
    @Column(columnDefinition = "LongBLOB")  
	private byte[] imagepath; // db longblob
	@Column(columnDefinition = "LongBLOB") 
	private String image;  // db longblob
	private String productname;
	private double price;
	
	
		
	public cartdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}


	public int getCartID() {
		return cartID;
	}



	public void setCartID(int cartID) {
		this.cartID = cartID;
	}



	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	
	




	public String getImage() {
		return image;
	}
	public void setImage(String imageData) {
		this.image = imageData;
	}
	
	
	
	public byte[] getImagepath() {
		return imagepath;
	}


	public void setImagepath(byte[] imagepath) {
		this.imagepath = imagepath;
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
	
	
	
}
