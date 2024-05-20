package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VWishList;

public interface VWishListRepository extends JpaRepository<VWishList, Integer> {
	List<VWishList> findBycustomerId(Integer customerId);

}
