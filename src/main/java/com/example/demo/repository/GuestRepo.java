package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GuestModel;



@Repository
public interface GuestRepo extends CrudRepository<GuestModel,Integer> {

	//create table Guest (id number primary key, name varchar2(20),email varchar2(30) unique,password varchar2(20),mobileNo varchar2(12));
	// insert into guest_model values (1,'praveenaditya@gmail.com','9898765458','raj','12345');
	
	Iterable<GuestModel> findByEmail(String email);


}
