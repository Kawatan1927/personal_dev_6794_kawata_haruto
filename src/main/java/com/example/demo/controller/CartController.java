package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.model.Cart;
import com.example.demo.repository.ItemImagesRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.MakeTimesaleList;
import com.example.demo.service.MakeTimesaleMapService;

@Controller
public class CartController {
	
	@Autowired
	Cart cart;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemImagesRepository itemImagesRepository;
	
	@Autowired
	MakeTimesaleList makeTimesaleList;
	
	@Autowired
	MakeTimesaleMapService makeTimesaleMapService;
	
	//カート内容を表示
	@GetMapping("/cart")
	public String index(
			@RequestParam(name = "itemId", defaultValue = "" ) Integer itemId,
			@RequestParam(name = "quantity", defaultValue = "" ) Integer quantity,						
			Model model) {
		//セール情報の取得
		List<Integer> timesaleItemList = makeTimesaleList.generate();
		Map<Integer, Double> timesaleMap =  makeTimesaleMapService.generate();
		model.addAttribute("saleItems", timesaleItemList);
		model.addAttribute("salemaps", timesaleMap);
		if(itemId != null) {
			cart.updateItems(itemId, quantity);
		}
		Map<Integer, List<ItemImage>> imageMap = new HashMap<>();
		List <Item> list = cart.getItemList();
		for(int i = 0; i < list.size(); i++) {
			Item item = list.get(i);
			Integer id = item.getId();
			List<ItemImage> images = itemImagesRepository.findByItemId(id);
			imageMap.put(item.getId(), images);
		}
        model.addAttribute("imageMap", imageMap);
		//cart.htmlの出力
		return "cart";
	}
	
	//指定した商品をカートに追加する
	//数量が未指定の場合は１とする
	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("itemId") int itemId,
			@RequestParam(name = "quantity", defaultValue = "1" )
			Integer quantity) {
		
		//商品コードをキーに商品情報を取得する
		Item item = itemRepository.findById(itemId).get();
		//商品オブジェクトに個数をセット
		item.setQuantity(quantity);
		//カートに追加
		cart.add(item);
		//「/cart」にリダイレクト
		return "redirect:/cart";
	}
	
	//指定した商品をカートから削除
	@PostMapping("/cart/delete")
	public String deleteCart(
			@RequestParam("itemId") int itemId) {
		//カートに追加
		cart.delete(itemId);
		//「/cart」にリダイレクト
		return "redirect:/cart";
	}
	

}
