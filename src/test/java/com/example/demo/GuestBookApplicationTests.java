package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Controller.GuestController;

@SpringBootTest
class GuestBookApplicationTests {

	@Autowired
	GuestController controller;
	
	@Test
	public void login() throws Exception {
		assertThat(controller).isNotNull();
	}
	@Test
	public void registration() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void updateAddress() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void verifiedGuest() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void deleteGuest() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void index() throws Exception {
		assertThat(controller).isNotNull();
	}

}
