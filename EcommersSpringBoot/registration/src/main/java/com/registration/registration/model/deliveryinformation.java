package com.registration.registration.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class deliveryinformation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryID;

	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;
	
//	@OneToOne(targetEntity = foodproduct.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "foodproductID", referencedColumnName = "productID")
//    private List<foodproduct> food;
//	
//	@OneToOne(targetEntity = skinproducts.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "skinproductID", referencedColumnName = "productID")
//    private List<skinproducts> skin;
    
//    @OneToOne(targetEntity = cartdetails.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "producID")
//    private cartdetails cart;  
	
	
	private int pid;
    private String address;
    private String city;
    private String pincode;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

   
	public deliveryinformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public deliveryinformation(int deliveryID, User user, int pid, String address, String city, String pincode,
			String firstname, String lastname, String email, String phone) {
		super();
		this.deliveryID = deliveryID;
		this.user = user;
		this.pid = pid;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}



	public int getDeliveryID() {
		return deliveryID;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public void setDeliveryID(int deliveryID) {
		this.deliveryID = deliveryID;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	


	
}
