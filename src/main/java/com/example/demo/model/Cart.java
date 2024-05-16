package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Item;

@Component
@SessionScope
public class Cart {
	
	//商品リスト
	private List<Item> itemList = new ArrayList<>();

	
	//商品リストゲッター
	public List<Item> getItemList() {
		return itemList;
	}
	
	//合計金額取得用ゲッター
	public Integer getTotalPrice() {
		//合計金額
		int total = 0;
		for(Item item : itemList) {
			total += item.getPrice() * item.getQuantity();
		}
		
		return total;
	}
	
	//獲得予定ポイント取得用ゲッター
	public int getTotalPoint() {
		int total = 0;
		for(Item item : itemList) {
			total += item.getPrice() * 0.1;
		}
		return total;
	}
	
	//カート追加
	public void add(Item newItem) {
		Item existsItem = null;
		//現在のカートの商品から同一IDの商品を探す
		for(Item item : itemList) {
			if(item.getId() == newItem.getId()) {
				existsItem = item;
				break;
			}
		}
		
		//カート内に用品が存在しなかった場合はカート追加
		//存在した場合は個数の更新を行う
		if(existsItem == null) {
			itemList.add(newItem);
		}else {
			existsItem.setQuantity(
					existsItem.getQuantity() + newItem.getQuantity());
		}
	}
	
	//カートから商品を削除
	public void delete(int itemId) {
		//現在のカートの商品から同一IDの商品を探す
		for(Item item : itemList) {
			if(item.getId() == itemId) {
				itemList.remove(item);
				break;
			}
			
		}
		
	}
	
	//カートの中身を全てクリア
	public void clear() {
		itemList = new ArrayList<>();
		
	}
	
	
	
	

}
