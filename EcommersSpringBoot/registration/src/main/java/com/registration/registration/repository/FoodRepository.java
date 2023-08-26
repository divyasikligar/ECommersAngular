package com.registration.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.registration.model.foodproduct;

public interface FoodRepository extends JpaRepository<foodproduct, Integer>{


	
}