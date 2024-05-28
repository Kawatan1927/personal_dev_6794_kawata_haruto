package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Item;
import com.example.demo.repository.TimeSaleRepository;
import com.example.demo.service.MakeTimesaleList;
import com.example.demo.service.MakeTimesaleMapService;

@Component
@SessionScope
public class Cart {

	@Autowired
	Account account;

	@Autowired
	MakeTimesaleList makeTimesaleList;

	@Autowired
	MakeTimesaleMapService makeTimesaleMapService;

	@Autowired
	TimeSaleRepository timeSaleRepository;

	//商品リスト
	private List<Item> itemList = new ArrayList<>();

	//商品リストゲッター
	public List<Item> getItemList() {
		return itemList;
	}

	//合計金額取得用ゲッター
	public Integer getTotalPrice() {
		//セール情報の取得
		List<Integer> timesaleItemList = makeTimesaleList.generate();
		Map<Integer, Double> timesaleMap = makeTimesaleMapService.generate();
		//合計金額
		int total = 0;
		if (timesaleItemList.size() == 0) {
			for (Item item : itemList) {
				total += item.getPrice() * item.getQuantity() - account.getUsePoint();
			}
			total -= account.getUsePoint();
			return total;
		} else {
			int i = 0;
			for (Item item : itemList) {
				for (Integer saleId : timesaleItemList) {
					if (item.getId() == saleId) {
						total += item.getPrice() * timesaleMap.get(item.getId()) * item.getQuantity();
						i += 1;
						break;
					}
				}
				if (i == 0) {
					total += item.getPrice() * item.getQuantity();
				}
			}
			total -= account.getUsePoint();
			return total;
		}

	}

	//カート追加
	public void add(Item newItem) {
		account.setUsePoint(0);
		Item existsItem = null;
		//現在のカートの商品から同一IDの商品を探す
		for (Item item : itemList) {
			if (item.getId() == newItem.getId()) {
				existsItem = item;
				break;
			}
		}

		//カート内に用品が存在しなかった場合はカート追加
		//存在した場合は個数の更新を行う
		if (existsItem == null) {
			itemList.add(newItem);
		} else {
			existsItem.setQuantity(existsItem.getQuantity() + newItem.getQuantity());
		}
	}

	//	カートの個数を更新する
	public void updateItems(Integer itemId, Integer quantity) {
		Item existsItem = null;
		//現在のカートの商品から同一のIDの商品を探す
		for (Item item : itemList) {
			if (item.getId() == itemId) {
				existsItem = item;
				break;
			}
		}
		if (existsItem != null) {
			//個数の更新をセットする
			existsItem.setQuantity(quantity);
		}
	}

	//カートから商品を削除
	public void delete(int itemId) {
		//現在のカートの商品から同一IDの商品を探す
		for (Item item : itemList) {
			if (item.getId() == itemId) {
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
