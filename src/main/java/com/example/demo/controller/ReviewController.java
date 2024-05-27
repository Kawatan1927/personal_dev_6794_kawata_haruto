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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.Review;
import com.example.demo.entity.VOrderDetail;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemImagesRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.VOrderDetailRepository;
import com.example.demo.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	VOrderDetailRepository vOrderDetailRepository;

	@Autowired
	ItemImagesRepository itemImagesRepository;
	
	@Autowired
	ItemRepository itemRepository;

	@Autowired
	Account account;
	
	@Autowired
	ReviewService reviewService;

	//カスタマーレビュー確認画面の表示
	@GetMapping("/items/{id}/review")
	public String index(@PathVariable("id") Integer id, Model model) {
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		List<Review> reviewList = reviewRepository.findByItemId(id);
		double averageScore = reviewService.calculateAverageReviewScore(id);
		model.addAttribute("reviews", reviewList);
		model.addAttribute("averageScore", averageScore);

		return "review";

	}

	//カスタマーレビュー投稿画面の表示
	@GetMapping("/order-history/{orderId}/addreview")
	public String create(@PathVariable("orderId") Integer id, Model model) {
		// オーダーIDからオーダー詳細を取得
		List<VOrderDetail> orderDetailList = vOrderDetailRepository.findByOrderIdAndCustomerId(id, account.getUserId());
		model.addAttribute("orderDetails", orderDetailList);
		// アイテムIDを取得
		Integer itemId = orderDetailList.get(0).getItemId();
		model.addAttribute("itemId", itemId);
		List<ItemImage> itemImageList = itemImagesRepository.findByItemId(itemId);
		model.addAttribute("itemImages", itemImageList);
		return "reviewForm";
	}

	//レビュー投稿処理
	@PostMapping("/order-history/{orderId}/addreview")
	public String save(@PathVariable("orderId") Integer orderId,
			@RequestParam(name = "reviewTitle", defaultValue = "") String reviewTitle,
			@RequestParam(name = "reviewImage", defaultValue = "") String reviewImage,
			@RequestParam(name = "reviewScore", defaultValue = "") Integer reviewScore,
			@RequestParam(name = "reviewDetail", defaultValue = "") String reviewDetail, Model model) {
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
			Review review = new Review(reviewTitle, reviewScore, reviewImage, reviewDetail);
			model.addAttribute("review", review);
			return "reviewForm";
		} else {
			// オーダーIDからアイテムIDを取得
			List<VOrderDetail> orderDetailList = vOrderDetailRepository.findByOrderIdAndCustomerId(orderId,
					account.getUserId());
			Integer itemId = orderDetailList.get(0).getItemId();
			LocalDate reviewedOn = LocalDate.now();
			Review review = new Review(itemId, account.getUserId(), reviewedOn, reviewTitle, reviewScore, reviewImage,
					reviewDetail);
			reviewRepository.save(review);
			return "accountDetail";
		}
	}
	
	//レビュー高評価付与処理
	  @PostMapping("/upvote")
	    public String upvote(
	    		@RequestParam("reviewId") Integer reviewId, 
	    		@RequestParam("itemId") Integer itemId,
	    		RedirectAttributes redirectAttributes) {
		  boolean success = reviewService.incrementUpvote(reviewId);
	        if (success) {
	            redirectAttributes.addFlashAttribute("message", "高評価を送信しました！");
	        } else {
	            redirectAttributes.addFlashAttribute("error", "高評価の送信に失敗しました。");
	        }
	        return "redirect:/items/" + itemId + "/review";
	  }
	  
	  //レビュー低評価付与処理
	  @PostMapping("/downvote")
	    public String downvote(
	    		@RequestParam("reviewId") Integer reviewId,
	    		@RequestParam("itemId") Integer itemId,
	    		RedirectAttributes redirectAttributes) {
	        boolean success = reviewService.incrementDownvote(reviewId);
	        if (success) {
	            redirectAttributes.addFlashAttribute("message", "低評価を送信しました！");
	        } else {
	            redirectAttributes.addFlashAttribute("error", "低評価の送信に失敗しました。");
	        }
	        return "redirect:/items/" + itemId + "/review";
	    }

}
