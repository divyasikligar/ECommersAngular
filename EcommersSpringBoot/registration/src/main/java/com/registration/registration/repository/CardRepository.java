package com.registration.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.registration.registration.model.cartdetails;

public interface CardRepository  extends JpaRepository<cartdetails, Integer>{
//	
//	@Query("SELECT ci.product FROM CartItem ci WHERE ci.product.id = ?1")
//	Product findProductById(Long productId);


	
}
