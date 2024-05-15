package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String address;
	
	private String tel;
	
	private String email;
	
	private String password;
	
	private Integer point;
	
	public Customer(Integer id, String name, String address, String tel, String email, Integer point) {
		this.name = name;
		this.address = address;
		this.tel = tel; 
		this.email = email;
		this.point = point;
		
	}
	public Customer(String name, String address, String tel, String email, Integer point) {
		this.name = name;
		this.address = address;
		this.tel = tel; 
		this.email = email;
		this.point = point;
		
	}
	
	public Customer(String name, String address, String tel, String email, String password) {
		this.name = name;
		this.address = address;
		this.tel = tel; 
		this.email = email;
		this.password = password;

		
		
	}
	
	public Customer(String name, String address, String tel, String email, String password, Integer point) {
		this.name = name;
		this.address = address;
		this.tel = tel; 
		this.email = email;
		this.password = password;
		this.point = point;

		
		
	}
	
	
	

}
