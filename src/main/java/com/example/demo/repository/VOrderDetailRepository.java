package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VOrderDetail;


public interface VOrderDetailRepository extends JpaRepository<com.example.demo.entity.VOrderDetail, Integer> {
	List<VOrderDetail> findBycustomerId(Integer customerId);

}
