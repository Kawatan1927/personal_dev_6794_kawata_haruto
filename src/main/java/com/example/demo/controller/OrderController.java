package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Coupon;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.CouponService;
import com.example.demo.service.MakeTimesaleList;
import com.example.demo.service.MakeTimesaleMapService;

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
	CouponRepository couponRepository;

	@Autowired
	Account account;
	
	@Autowired
	CouponService couponService;
	
	@Autowired
	MakeTimesaleList makeTimesaleList;
	
	@Autowired
	MakeTimesaleMapService makeTimesaleMapService;

	//注文内容確認とお客様情報確認画面を表示
	@GetMapping("/order")
	public String index(@RequestParam(name = "usePoint", required = false) Integer usePoint,
						@ModelAttribute("couponError") String couponError,
		
						Model model) {
		if(usePoint != null) {
			account.setUsePoint(usePoint);
			model.addAttribute("usePoint", usePoint);
		}else {
			model.addAttribute("usePoint", account.getUsePoint());
		}
		//セール情報の取得
		List<Integer> timesaleItemList = makeTimesaleList.generate();
		Map<Integer, Double> timesaleMap =  makeTimesaleMapService.generate();
		model.addAttribute("saleItems", timesaleItemList);
		model.addAttribute("salemaps", timesaleMap);
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
			@RequestParam(name ="usePoint", defaultValue = "0") Integer usePoint,
			@RequestParam(name = "couponCode", required = false) String couponCode,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		
		
		//1.ポイント獲得情報をDBに格納する
		Customer customer = customerRepository.findById(id).get();
		customer.setPoint(customer.getPoint() + point - account.getUsePoint());
		account.setGetPoint(point);
		account.setUserPoint(account.getUserPoint() + point - account.getUsePoint());
		customerRepository.save(customer);
		//2.注文情報をDBに格納する
		Order order = new Order(customer.getId(), LocalDate.now(), cart.getTotalPrice());
		orderRepository.save(order);
		//3.注文詳細情報をDBに格納する
		List<Item> itemList = cart.getItemList();
		List<OrderDetail> orderDetails = new ArrayList<>();
		for (Item item : itemList) {
			orderDetails.add(new OrderDetail(order.getId(), item.getId(), item.getQuantity()));
		}
		orderDetailRepository.saveAll(orderDetails);
		
		//4.クーポン利用処理
		if (couponCode != null && !couponCode.isEmpty()) {
	        Coupon coupon = couponService.findByCode(couponCode);
	        if (coupon != null && !coupon.isUsed()) {
	            order.setTotalPrice(order.getTotalPrice() * (1 - coupon.getDiscount()));
	            coupon.setUsed(true);
	            couponRepository.save(coupon);
	            orderRepository.save(order);  // 更新された合計金額を保存
	            model.addAttribute("couponApplied", true);
	        } else {
	        	redirectAttributes.addFlashAttribute("couponError", "クーポンは使用済みです。");
	            return "redirect:/order";
	        }
	    }
		
		//5.クーポン発行抽選
		Coupon coupon = couponService.generateCoupon();
        if (coupon != null) {
            int couponFlag = 1;
            model.addAttribute("couponFlag", couponFlag);
        } else {
            
        }

		//セッションスコープのカート情報をクリアする
		cart.clear();

		//画面返却用番号・付与ポイント数を設定する
		model.addAttribute("orderNumber", order.getId());
		model.addAttribute("getPoints", account.getGetPoint());
		model.addAttribute("usePoint", usePoint);

		return "ordered";
	}

}
