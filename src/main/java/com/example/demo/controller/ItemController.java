package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.WishList;
import com.example.demo.model.Account;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemImagesRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.WishListRepository;

@Controller
public class ItemController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemImagesRepository itemImagesRepository;
	
	@Autowired
	WishListRepository wishListRepository;
	
	@Autowired
	Account account;
	
	//商品一覧表示
	@GetMapping("/items")
	public String index(
			@RequestParam(value = "categoryId", defaultValue = "")
			Integer categoryId,
			@RequestParam(name = "keyword", defaultValue = "")
			String keyword,
			Model model) {
		
		//全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);
		
		//検索キーワードを取得
		model.addAttribute("keyword", keyword);
		
		//商品一覧情報の取得
		List<Item> itemList = null;
		if(categoryId == null) {
			if(!(keyword.equals(""))) {
				itemList = itemRepository.findByNameLike("%"+keyword+"%");
			}else {
				itemList = itemRepository.findAll();
			}
		}else {
			//itemsテーブルをカテゴリーIDを指定して一覧を取得
			itemList = itemRepository.findByCategoryId(categoryId);
		}
		model.addAttribute("items", itemList);
		
		return "items";
	}
	
	//商品詳細画面表示
	@GetMapping("/items/{id}")
	public String show(
			@PathVariable("id") Integer id,
			Model model) {

		// 主キー検索
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		ItemImage itemimage1 = itemImagesRepository.findByItemId(id).get(0);
		model.addAttribute("itemimage1", itemimage1);
		ItemImage itemimage2 = itemImagesRepository.findByItemId(id).get(1);
		model.addAttribute("itemimage2", itemimage2);
		ItemImage itemimage3 = itemImagesRepository.findByItemId(id).get(2);
		model.addAttribute("itemimage3", itemimage3);
		

		return "itemDetail";
	}
	
	@PostMapping("/wishlist/add")
	public String addWishList(
			@RequestParam("itemId") Integer id,
			Model model) {
		WishList wishlist = new WishList(id, account.getUserId());
		wishListRepository.save(wishlist);
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		ItemImage itemimage1 = itemImagesRepository.findByItemId(id).get(0);
		model.addAttribute("itemimage1", itemimage1);
		ItemImage itemimage2 = itemImagesRepository.findByItemId(id).get(1);
		model.addAttribute("itemimage2", itemimage2);
		ItemImage itemimage3 = itemImagesRepository.findByItemId(id).get(2);
		model.addAttribute("itemimage3", itemimage3);
		return "itemDetail";
	}
	
	@PostMapping("/wishlist/delete")
	public String deleteWishList(
			@RequestParam("itemId") Integer id,
			Model model) {
		WishList wishlist = new WishList(id, account.getUserId());
		wishListRepository.delete(wishlist);
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		return "wishList";
	}

}
