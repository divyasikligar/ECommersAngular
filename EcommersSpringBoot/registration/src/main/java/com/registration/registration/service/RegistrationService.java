package com.registration.registration.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.registration.model.User;
import com.registration.registration.model.cartdeliverydetails;
import com.registration.registration.model.cartdetails;
import com.registration.registration.model.deliveryinformation;
import com.registration.registration.model.foodproduct;
import com.registration.registration.model.skinproducts;
import com.registration.registration.repository.CardRepository;
import com.registration.registration.repository.CartDeliveryRepository;
import com.registration.registration.repository.DeliveryInfoRepository;
import com.registration.registration.repository.FoodRepository;
import com.registration.registration.repository.RegistrationRepository;
import com.registration.registration.repository.SkinRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
		
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	
	public User fetchUserByEmailId(String email)
	{
		return repo.findByEmailId(email);
	}
	
	
	public User fetchUserByEmailIdAndPassword(String email, String password)
	{
		return repo.findByEmailIdAndPassword(email, password);
	}
	
	public User fetchUserById(int uid)
	{
		return repo.findByid(uid);
	}
	
	@Autowired
	private SkinRepository skinrepo;
	
	public List<skinproducts> getSkinProduct()
	{
		List<skinproducts> products = skinrepo.findAll();
	    
	   
	    return products;
	}
	 

	@Autowired
	private FoodRepository foodrepo;
	public List<foodproduct> getFoodProduct()
	{
		List<foodproduct> products = foodrepo.findAll();
	    
		return products;
	}
	

	
	
	@Autowired
	private DeliveryInfoRepository deliveryrepo;
	public deliveryinformation saveDeliveryInfo(deliveryinformation dlver) {
		
		return deliveryrepo.save(dlver);
	}
	
	
	
	
	@Autowired
	private CardRepository cdrepo;
	public cartdetails saveCD(cartdetails cd)
	{
		return cdrepo.save(cd);
		
	}
	
	

	public List<cartdetails> findCD()
	{
		cartdetails cdt = new cartdetails();
		
		return cdrepo.findAll();
	}
	 
	
	
	@Autowired
	private CartDeliveryRepository cartdelirepo;
	public List<cartdeliverydetails> fetchUserCartDelivery(int id) {
		
		return cartdelirepo.fetchcartdeliverydetails(id);
	}
	
//	public List<cartdeliverydetails> saveCartDelivery(List<cartdeliverydetails> userobj1)
//	{
//		return  cartdelirepo.save(userobj1);
//	}
	 
	
}
