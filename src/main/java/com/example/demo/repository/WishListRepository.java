package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
	List<WishList> findBycustomerId(Integer customerId);
	
	boolean existsByItemIdAndCustomerId(Integer itemId, Integer customerId);
	
	WishList findByItemIdAndCustomerId(Integer itemId, Integer customerId);

}
