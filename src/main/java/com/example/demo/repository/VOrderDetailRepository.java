package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VOrderDetail;


public interface VOrderDetailRepository extends JpaRepository<com.example.demo.entity.VOrderDetail, Integer> {
	//SELECT * FROM v_order_details WHERE category_id = ?
	List<VOrderDetail> findBycustomerId(Integer customerId);
	//SELECT * FROM v_order_details WHERE id = ? AND category_id = ?
	List<VOrderDetail> findByOrderIdAndCustomerId(Integer orderId, Integer customerId);

}
