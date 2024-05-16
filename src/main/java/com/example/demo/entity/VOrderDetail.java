package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "v_order_details") //対応するView名
@Getter
public class VOrderDetail {
	//フィールド
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //注文明細ID
	@Column(name = "order_id")
	private Integer orderId; //注文ID
	@Column(name = "customer_id")
	private Integer customerId; // 顧客ID
	@Column(name = "ordered_on")
	private LocalDate orderedOn; // 注文日
	
	@Column(name = "item_id")
	private Integer itemId; // 商品ID
	
	private String name; /*商品名*/
	
	private Integer price; //価格
	
	private Integer quantity; // 数量
	
	@Column(name = "total_price")
	private Integer totalPrice; // 合計金額

}
