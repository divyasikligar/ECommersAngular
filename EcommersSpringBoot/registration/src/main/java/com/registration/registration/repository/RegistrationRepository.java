package com.registration.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.registration.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{

   public User findByEmailId(String email);
   
   public User findByEmailIdAndPassword(String email, String password);
   
   public User findByid(int uid);

}


