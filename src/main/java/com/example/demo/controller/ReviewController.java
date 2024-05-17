package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@GetMapping("/items/{id}/review")
	public String index(
			@PathVariable("id") Integer id,
			Model model) {
		List<Review> reviewList = reviewRepository.findByItemId(id);
		
		model.addAttribute("reviews",reviewList);
		
		return  "review";
		
	}
	
	@GetMapping("/order-history/{itemId}/addreview")
	public String create(
			@PathVariable("itemId") Integer id,
			Model model) {
		List<Review> reviewList = reviewRepository.findByItemId(id);
		model.addAttribute("reviews",reviewList);
		return  "reviewForm";
	}
	
	

}
