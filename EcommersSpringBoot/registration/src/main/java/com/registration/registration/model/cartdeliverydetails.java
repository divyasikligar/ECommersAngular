package com.registration.registration.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;

@Entity
public class cartdeliverydetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//private int cdid;
	private int deliveryID;
	private String address;
	private String city;
	private int pincode;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private int pid;
	private int productID;
	private int cartid;
	private String productname;
	private byte[] imagepath;
	private double price;
	
	public cartdeliverydetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	




	public cartdeliverydetails( int deliveryID, String address, String city, int pincode, String firstname,
			String lastname, String email, String phone, int pid, int productID, int cartid, String productname,
			byte[] imagepath, double productprice) {
		super();
		this.deliveryID = deliveryID;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.pid = pid;
		this.productID = productID;
		this.cartid = cartid;
		this.productname = productname;
		this.imagepath = imagepath;
		this.price = productprice;
	}






	

	public int getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(int deliveryID) {
		this.deliveryID = deliveryID;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public byte[] getImagepath() {
		return imagepath;
	}

	public void setImagepath(byte[] imagepath) {
		this.imagepath = imagepath;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
