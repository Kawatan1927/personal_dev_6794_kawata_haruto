package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@SessionScope
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	public Integer userId;
	
	public String userEmail;
	
	public String userPassword;
	
	public String userName;
	
	public String userAddress;
	
	public String userTel;	
	
	public Integer userPoint;

	

	

}
