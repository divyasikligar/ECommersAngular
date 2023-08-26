package com.registration.registration.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.registration.model.User;
import com.registration.registration.model.cartdeliverydetails;
import com.registration.registration.model.cartdetails;
import com.registration.registration.model.deliveryinformation;
import com.registration.registration.model.foodproduct;
import com.registration.registration.model.skinproducts;
import com.registration.registration.service.RegistrationService;

@RestController

public class ResgistrationController {
	
	@Autowired
	private RegistrationService serv;
	User u = null;
//	List<foodproduct> f = null;
//	List<skinproducts> s = null;
	cartdetails c = null;
	
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser( @RequestBody User user) throws Exception
	{
		String tempEmailid = user.getEmailId();
		if(tempEmailid != null && !"".equals(tempEmailid))
		{
			User user1 = serv.fetchUserByEmailId(tempEmailid);
			
			if(user1 != null)
			{
				throw new Exception("User with " +tempEmailid+ " is already exist");
			}
		}
		
		User userobj; //User userobj = null;
		userobj = serv.saveUser(user);
		return userobj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userobj = null;
		
		if(tempEmailId != null && tempPass != null)
		{
		 userobj = serv.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
			
		}
		if(userobj == null)
		{
			throw new Exception("User does not exist");
		}
		u = userobj;
		System.out.println("user info in u =" + u);
		return userobj;
	}
	
//	@GetMapping("/skin")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public ResponseEntity<List<skinproducts>> getAllSkinProducts() {
////		List<skinproducts> products = serv.getSkinProduct();
////		List<skinproducts> productsDetails = new ArrayList<skinproducts>();
////		for (skinproducts i : products) {
////			skinproducts sp = new skinproducts();
////			sp.setPrice(i.getPrice());
////			sp.setProductID(i.getProductID());
////			sp.setProductname(i.getProductname());
////			sp.setSectionid(i.getSectionid());
////			sp.setImage(decompressBytes(i.getImage()));
////			productsDetails.add(sp);
////			System.out.println(productsDetails);
////		}
//
//		return new ResponseEntity<>(serv.getSkinProduct(), HttpStatus.OK);
//
//    }
	
	@GetMapping("/skin")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<skinproducts>> getAllSkinProducts() {
	    List<skinproducts> products = serv.getSkinProduct();
	    
	    // Set base64-encoded images for each product
//	    for (skinproducts product : products) {
////	        String base64Image = Base64.getEncoder().encodeToString(product.getImage());
////	        product.setBase64Image(base64Image);
//	    	
////	    	String imagePath = "/images/" + product.getImagePath();
////            product.setImagePath(imagePath);
//	    }
	    
	  	    return new ResponseEntity<>(products, HttpStatus.OK);
	}



	@GetMapping("/food")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<foodproduct>> getAllFoodProducts() {
        List<foodproduct> products = serv.getFoodProduct();
//        f = products;
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
	
	

	    @PostMapping("/delivery")
	    @CrossOrigin(origins = "http://localhost:4200")
	    public deliveryinformation addDeliverInfo(@RequestBody deliveryinformation deliveryInfo) throws Exception 
	    {
	        
	        	if(u != null) 
	        	{
		    		User userid = serv.fetchUserById(u.getId());
		    		System.out.println("delivery id =" + userid);
	    	    	deliveryInfo.setUser(userid);
	    	    }
	        	

                if(c != null) {
	        		
                	int pid = c.getProductID();
                	System.out.println("delivery pid =" + pid);
                	
	        		deliveryInfo.setPid(pid);
	        		
	        	}
	        	
	        	
	            deliveryinformation savedDeliveryInfo = serv.saveDeliveryInfo(deliveryInfo);
	            return savedDeliveryInfo;
	        
	    }
	
	
	 
	    
	    @PostMapping("/cartdetails")
	    @CrossOrigin(origins = "http://localhost:4200")
	    public cartdetails saveCd( @RequestBody cartdetails cd) throws Exception
		{
	    	
	    	
	    //	int uid = cd.getUser().getId();
	    	if(u != null) {
	    		
	    	
	    	User userid = serv.fetchUserById(u.getId());	
    		System.out.println("cart id =" + userid);
    		System.out.println("cart pid =" + cd.getProductID());


	    	cd.setUser(userid);
	    	}
	    	
	    	cartdetails userobj;//User userobj = null;
			byte[] imageData = Base64.getDecoder().decode(cd.getImage()); //// Assuming you have the image data as a string recieving img fron angulr in string & convert in base64
			cd.setImagepath(imageData); // set image in byte[] // Convert string to byte array
			userobj = serv.saveCD(cd);
			c = userobj;
			return userobj;
		} 
	    
	    @GetMapping("/cartdetails")
	    @CrossOrigin(origins = "http://localhost:4200")
	    public ResponseEntity<List<cartdetails>> findCd() throws Exception
		{
			
			
			List<cartdetails> userobj; //User userobj = null;
			userobj = serv.findCD();
			  return new ResponseEntity<>(userobj, HttpStatus.OK);
		} 
	    
	    
	    
	    @GetMapping("/cartdeliverydetails")
	    @CrossOrigin(origins = "http://localhost:4200")
	    public List<cartdeliverydetails> findCartDeliveryDetails() throws Exception
		{
	    	List<cartdeliverydetails> userobj1 = null;
			
			
			if(u != null) {
	    		
		    	
		    	int i = u.getId();
		    	System.out.println(u.getId());
				userobj1 = serv.fetchUserCartDelivery(i);	 
				
//				serv.saveCartDelivery(userobj1);
				 
		    	}
			
			return userobj1;
			
			
			
			 
		} 
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
//	    public static byte[] decompressBytes(byte[] data) {
//			Inflater inflater = new Inflater();
//			inflater.setInput(data);
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//			byte[] buffer = new byte[1024];
//			try {
//				while (!inflater.finished()) {
//					int count = inflater.inflate(buffer);
//					outputStream.write(buffer, 0, count);
//				}
//				outputStream.close();
//			} catch (IOException ioe) {
//			} catch (DataFormatException e) {
//			}
//			return outputStream.toByteArray();
//		}
//	    
//	    
	    
	    
}
