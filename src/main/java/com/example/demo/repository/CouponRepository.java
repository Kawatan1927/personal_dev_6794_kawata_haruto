package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
