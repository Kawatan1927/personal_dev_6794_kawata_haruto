package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.PasswordResetToken;
import com.example.demo.repository.TokenRepository;

@Service
public class TokenService {
	
	 @Autowired
	 private TokenRepository tokenRepository;
	 
	 public String createToken(Customer customer) {
	        String token = UUID.randomUUID().toString(); // トークンの生成
	        PasswordResetToken passwordResetToken = new PasswordResetToken(token, customer, LocalDateTime.now().plusHours(1)); // トークンエンティティの作成
	        tokenRepository.save(passwordResetToken); // トークンエンティティの保存
	        return token; // 生成されたトークンを返す
	    }

	    public boolean isValid(String token) {
	        PasswordResetToken resetToken = tokenRepository.findByToken(token); // トークンの検索
	        return resetToken != null && resetToken.getExpiryDate().isAfter(LocalDateTime.now()); // トークンが存在し、有効期限内かを確認
	    }

	    public Customer getUserByToken(String token) {
	        PasswordResetToken resetToken = tokenRepository.findByToken(token); // トークンの検索
	        return resetToken != null ? resetToken.getCustomer() : null; // トークンに対応するユーザーを返す
	    }

}
