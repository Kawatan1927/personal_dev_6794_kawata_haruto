package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //商品ID

	@Column(name = "category_id")
	private Integer categoryId; //カテゴリーID

	private String name; /*商品名*/

	private String detail; /*商品詳細*/

	private Integer price; //価格

	@Transient //永続化対象外
	private Integer quantity; //数量

	@OneToMany
	@JoinColumn(name = "id")
	private List<ItemImage> itemImage;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Timesale> timesale;

}
