package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "timesale")
@Getter
@Setter
public class Timesale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //商品ID

	@ManyToOne
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;

	@Column(name = "start_time", nullable = false)
	private LocalDateTime startTime;

	@Column(name = "end_time", nullable = false)
	private LocalDateTime endTime;

	@Column(name = "discount_price", nullable = false)
	private BigDecimal discountPrice;

}
