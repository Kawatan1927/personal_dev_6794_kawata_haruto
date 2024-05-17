package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Order;
import com.example.demo.entity.Review;
import com.example.demo.model.Account;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ReviewRepository;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	Account account;
	//カスタマーレビュー確認画面の表示
	@GetMapping("/items/{id}/review")
	public String index(
			@PathVariable("id") Integer id,
			Model model) {
		List<Review> reviewList = reviewRepository.findByItemId(id);
		
		model.addAttribute("reviews",reviewList);
		
		return  "review";
		
	}
	
	//カスタマーレビュー投稿画面の表示
	@GetMapping("/order-history/{itemId}/addreview")
	public String create(
			@PathVariable("itemId") Integer id,
			Model model) {
		model.addAttribute("itemId",id);
		return  "reviewForm";
	}
	
	//レビュー投稿処理
	@PostMapping("/order-history/{itemId}/addreview")
	public String save(
			@PathVariable("itemId") Integer id,
			@RequestParam(name = "reviewTitle" , defaultValue = "") String reviewTitle,
			@RequestParam(name = "reviewScore" , defaultValue = "") Integer reviewScore,
			@RequestParam(name = "reviewDetail" , defaultValue = "") String reviewDetail,
			Model model) {
		model.addAttribute("reviewTitle", reviewTitle);
		model.addAttribute("reviewScore", reviewScore);
		model.addAttribute("reviewDetail", reviewDetail);
		
		// エラーチェック
		List<String> errorList = new ArrayList<String>();
		
		if (reviewTitle.length() == 0) {
			errorList.add("レビュータイトルは必須です");
		}
		if (reviewScore == null) {
			errorList.add("評価は必須です");
		}
		if (reviewDetail.length() == 0) {
			errorList.add("レビュー詳細は必須です");
		}
		// エラー発生時はレビュー登録画面に戻す
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			Review review = new Review(reviewTitle, reviewScore, reviewDetail);
			model.addAttribute("review",review);
			return "accountForm";
		}else {
			Integer itemId =id;
			Order order = orderRepository.findByCustomerId(itemId).get(0);
			LocalDate reviewedOn = order.getOrderedOn();
			Review review = new Review(itemId, account.getUserId(), reviewedOn, reviewTitle, reviewScore, reviewDetail);
			reviewRepository.save(review);
			return "accountConfirm";
		}
}
	
	

}
