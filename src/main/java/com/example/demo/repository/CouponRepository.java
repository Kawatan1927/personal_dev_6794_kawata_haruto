package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	@Query(value = "select * from Coupon c where c.customer_id = :customerId ", nativeQuery = true)
	public List<Coupon> findCoupons(@Param("customerId") Integer customerId);
	
	 Optional<Coupon> findByCode(String code);

}
