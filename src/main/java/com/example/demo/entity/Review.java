package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //カテゴリーID
	@Column(name = "item_id")
	private Integer itemId; // 商品ID
	@Column(name = "customer_id")
	private Integer customerId; // 顧客ID
	@Column(name = "reviewed_on")
	private LocalDate reviewedOn; // レビュー日
	@Column(name = "review_title")
	private String reviewTitle; // レビュータイトル
	@Column(name = "review_score")
	private String reviewScore; // レビュータイトル
	@Column(name = "review_detail")
	private String reviewDetail; // レビュー内容
	private Integer good; // 高評価
	private Integer bad; // 低評価

}
