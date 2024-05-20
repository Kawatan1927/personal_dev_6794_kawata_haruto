package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_images")
@Getter
@Setter
public class ItemImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //商品画像ID
	
	@Column(name = "item_id")
	private Integer itemId; // 商品ID
	
	private String image; /*商品画像*/
	
	@ManyToOne
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;
	
	

}
