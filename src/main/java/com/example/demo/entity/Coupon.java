package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id; 
	 private String code;
	 private double discount;
	 private boolean isUsed;
	 
	 

}