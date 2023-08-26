package com.registration.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.registration.registration.model.cartdeliverydetails;

public interface CartDeliveryRepository extends JpaRepository<cartdeliverydetails, Integer>{

//	@Procedure("fetchcartdetails")
//	public List<cartdeliverydetails> fetchcartdetails(int id);
	
	@Query(value= "{call fetchcartdeliverydetails(:checkid)}",nativeQuery=true)
	public List<cartdeliverydetails> fetchcartdeliverydetails(@Param("checkid")int checkid);

//	@Query(value = "SELECT "
//	        + "DeliveryInformation.address, "
//	        + "DeliveryInformation.city, "
//	        + "DeliveryInformation.pincode, "
//	        + "DeliveryInformation.firstname, "
//	        + "DeliveryInformation.lastname, "
//	        + "DeliveryInformation.email, "
//	        + "DeliveryInformation.phone, "
//	        + "DeliveryInformation.pid, "
//	        + "CartDetails.productid, "
//	        + "CartDetails.cartid, "
//	        + "CartDetails.productname, "
//	        + "CartDetails.imagepath, "
//	        + "CartDetails.price "
//	        + "FROM CartDetails "
//	        + "INNER JOIN DeliveryInformation ON CartDetails.productid = DeliveryInformation.pid "
//	        + "WHERE CartDetails.id = :checkid AND DeliveryInformation.id = :checkid", nativeQuery = true)
//	public List<cartdeliverydetails> fetchcartdeliverydetails1(@Param("checkid") int checkid);

}
