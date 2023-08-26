package com.registration.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.registration.model.skinproducts;

public interface SkinRepository extends JpaRepository<skinproducts, Integer> {

	
}
