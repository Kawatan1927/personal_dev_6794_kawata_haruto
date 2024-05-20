package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wishlists")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WishList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //欲しいものリストID
	
	@Column(name = "item_id")
	private Integer itemId; // 商品ID
	@Column(name = "customer_id")
	private Integer customerId; // 顧客ID
	
	public WishList(Integer itemId, Integer customerId) {
		this.itemId = itemId;
		this.customerId = customerId;
	}

}
