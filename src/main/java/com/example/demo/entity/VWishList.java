package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "v_wishlists") //対応するView名
@Getter
public class VWishList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //欲しいものリストID
	
	@Column(name = "item_id")
	private Integer itemId; // 商品ID
	@Column(name = "customer_id")
	private Integer customerId; // 顧客ID
	
	private String name; /*商品名*/
	
	private Integer price; //価格
	
	

}
