package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class GuestModel {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "guest_seq", allocationSize = 1, name = "SEQ")
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String mobileNo;
	@Column
	private String role;
	@Column
	private String address;
	@Column
	private String verified;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public GuestModel() {
		
	}
	public GuestModel(String name, String email, String password, String mobileNo,String role,String address,String verified) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.role=role;
		this.address=address;
		this.verified=verified;
	}
	
}
