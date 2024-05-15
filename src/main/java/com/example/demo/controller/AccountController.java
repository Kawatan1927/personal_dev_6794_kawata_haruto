package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	Account account;
	
	
	//ログイン画面を表示
	@GetMapping({"/", "/login", "/logout"})
	public String index(
			@RequestParam(name = "error", defaultValue = "")String error,
			Model model) {
		//セッション情報をすべてクリアする
		session.invalidate();
		//エラーパラメータのチェック
		if(error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}
		
	return "login";
	}
	
//	ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam(name = "email" , defaultValue = "") String userEmail,
	        @RequestParam(name = "password",  defaultValue = "") String userPassword,
			Model model) {
		List<Customer> customerList = customerRepository.findByEmailAndPassword(userEmail, userPassword);
		//
		if(userEmail == null || userEmail.length() == 0) {
			model.addAttribute("message", "メールアドレスを入力してください");
			return "login";
		}if(userPassword == null || userPassword.length() == 0) {
			model.addAttribute("message", "パスワードを入力してください");
			return "login";
		}
		if(customerList.size() == 0 ) {
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}
		Integer userId = customerList.get(0).getId();
		String userName = customerList.get(0).getName();
		String userAddress = customerList.get(0).getAddress();
		String userTel = customerList.get(0).getTel();
		Integer userPoint = customerList.get(0).getPoint();
		
		//セッション管理されたアカウント情報に名前をセット		
		account.setUserId(userId);
		account.setUserName(userName);
		account.setUserAddress(userAddress);
		account.setUserTel(userTel);
		account.setUserPoint(userPoint);
		account.setUserEmail(userEmail);
		account.setUserPassword(userPassword);
		
		//「/items」へのリダイレクト
		return "redirect:/items";
	}
	
	//ユーザー登録画面を表示
	@GetMapping("/add")
	public String create() {
		return "accountForm";
	}
	
	//ユーザー情報の確認画面を表示
	@PostMapping("/add/confirm")
	public String confirm(
			@RequestParam(name = "name" , defaultValue = "") String name,
			@RequestParam(name = "address" , defaultValue = "") String address,
			@RequestParam(name = "tel" , defaultValue = "") String tel,
			@RequestParam(name = "email",  defaultValue = "") String email,
			@RequestParam(name = "password",  defaultValue = "") String password,
			Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		
		List<String> errorList = new ArrayList<String>();
		List<Customer> customerList = customerRepository.findByEmail(email);

		if (name.length() == 0) {
			errorList.add("名前は必須です");
		}
		if (address.length() == 0) {
			errorList.add("住所は必須です");
		}
		if (tel.length() == 0) {
			errorList.add("電話番号は必須です");
		}
		if (email.length() == 0) {
			errorList.add("メールアドレスは必須です");
		}
		if(customerList.size() != 0 ) {
			errorList.add("登録済みのメールアドレスです");
		}
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		}
		
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			Customer customer = new Customer(name, address, tel, email, password);
			model.addAttribute("customer",customer);
			return "accountForm";
		}else {
			Customer customer = new Customer(name, address, tel, email, password);
			model.addAttribute("customer", customer);
			return "accountConfirm";
		}
		
		
	}
	
	//ユーザー情報を登録する
		@PostMapping("/entry")
		public String entry(
				@RequestParam(name = "name" , defaultValue = "") String name,
				@RequestParam(name = "address" , defaultValue = "") String address,
				@RequestParam(name = "tel" , defaultValue = "") String tel,
				@RequestParam(name = "email",  defaultValue = "") String email,
				@RequestParam(name = "password",  defaultValue = "") String password,
				Model model){
			Customer customer = new Customer(name, address, tel, email, password, 0);
			customerRepository.save(customer);
			return "login";
		}
	

}
