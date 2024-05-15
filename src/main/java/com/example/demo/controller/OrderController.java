package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class OrderController {
	
	@Autowired
	Cart cart;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	Account account;
	
	//注文内容確認とお客様情報確認画面を表示
	@GetMapping("/order")
	public String index() {
		return "customerForm";
	}
	
	//注文する
	@PostMapping("/order")
	public String order(
			@RequestParam("id") Integer id,
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("point") Integer point,
			Model model) {
		//1.ポイント獲得情報をDBに格納する
		Customer customer = customerRepository.findById(id).get();
		customer.setPoint(customer.getPoint() + point);
		account.setUserPoint(account.getUserPoint() + point);
		customerRepository.save(customer);
		//2.注文情報をDBに格納する
		Order order = new Order(
				customer.getId(),
				LocalDate.now(),
				cart.getTotalPrice());
		orderRepository.save(order);
		//3.注文詳細情報をDBに格納する
		List<Item> itemList = cart.getItemList();
		List<OrderDetail> orderDetails = new ArrayList<>();
		for(Item item : itemList) {
			orderDetails.add(
					new OrderDetail(
							order.getId(),
							item.getId(),
							item.getQuantity()));
		}
		orderDetailRepository.saveAll(orderDetails);
		
		//セッションスコープのカート情報をクリアする
		cart.clear();
		
		//画面返却用番号・付与ポイント数を設定する
		model.addAttribute("orderNumber", order.getId());
		model.addAttribute("getPoints", customer.getPoint());
		
		
		return "ordered";
	}
	

}
