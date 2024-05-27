package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	public boolean  incrementUpvote(Integer reviewId) {
		 try {
	            Review review = reviewRepository.findById(reviewId).orElseThrow();
	            review.setGood(review.getGood() + 1);
	            reviewRepository.save(review);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}
	
	 public boolean incrementDownvote(Integer reviewId) {
	        try {
	            Review review = reviewRepository.findById(reviewId).orElseThrow();
	            review.setBad(review.getBad() + 1);
	            reviewRepository.save(review);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	public double calculateAverageReviewScore(Integer itemId) {
		List<Review> reviews = reviewRepository.findByItemId(itemId);
		return reviews.stream().mapToInt(Review::getReviewScore).average().orElse(0.0);
	}

}
