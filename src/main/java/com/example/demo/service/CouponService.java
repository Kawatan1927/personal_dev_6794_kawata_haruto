package com.example.demo.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coupon;
import com.example.demo.model.Account;
import com.example.demo.repository.CouponRepository;

@Service
public class CouponService {
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	Account account;

	private Random random = new Random();

	public Coupon generateCoupon() {
		if (random.nextInt(10) == 0) { // 10%の確率
			Coupon coupon = new Coupon();
			coupon.setCustomerId(account.getUserId());
			coupon.setCode(UUID.randomUUID().toString());
			coupon.setDiscount(0.9); // 10%の割引
			coupon.setUsed(false);
			return couponRepository.save(coupon);
		}
		return null;
	}

}
