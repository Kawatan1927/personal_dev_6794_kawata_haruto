package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.VOrderDetail;
import com.example.demo.entity.VWishList;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.VOrderDetailRepository;
import com.example.demo.repository.VWishListRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	VOrderDetailRepository vOrderDetailRepository;	
	
	@Autowired
	VWishListRepository vWishListRepository;
	
	@Autowired
	Account account;
	
	
	//ログイン画面を表示
	@GetMapping({"/", "/login", "/logout"})
	public String index(
			@RequestParam(name = "error", defaultValue = "")String error,
			@RequestParam(name = "mode", defaultValue = "")String mode,			
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
		// メールアドレスが空の場合にエラーとする
		if(userEmail == null || userEmail.length() == 0) {
			model.addAttribute("message", "メールアドレスを入力してください");
			return "login";
		// パスワードが空の場合にエラーとする
		}if(userPassword == null || userPassword.length() == 0) {
			model.addAttribute("message", "パスワードを入力してください");
			return "login";
		}
		if(customerList.size() == 0 ) {
			// 存在しなかった場合
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}
		Integer userId = customerList.get(0).getId();
		String userName = customerList.get(0).getName();
		String userAddress = customerList.get(0).getAddress();
		String userTel = customerList.get(0).getTel();
		Integer userPoint = customerList.get(0).getPoint();
		
		// セッション管理されたアカウント情報に全てのアカウントをセット
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
		
		// エラーチェック
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
		// メールアドレス存在チェック
		if(customerList.size() != 0 ) {
			// 登録済みのメールアドレスが存在した場合
			errorList.add("登録済みのメールアドレスです");
		}
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		}
		
		// エラー発生時はユーザー登録画面に戻す
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
	
	//アカウントサービス画面を表示
	@GetMapping("/youraccount")
	public String mypage() {
		return "accountDetail";
	}
	
	//注文履歴画面を表示
	@GetMapping("/order-history")
	public String orderHistory(Model model) {
		List<Order> orderList = orderRepository.findAll();
		model.addAttribute("orders",orderList);
		List<VOrderDetail> orderDetailList = vOrderDetailRepository.findBycustomerId(account.getUserId());
		model.addAttribute("orderDetails",orderDetailList);		
		return "orderHistory";
	}
	
	//注文履歴詳細画面を表示
	@GetMapping("/order-history/{id}")
	public String orderHistoryShow(
			@PathVariable("id") Integer id,
			Model model) {
		Order orders = orderRepository.findById(id).get();
		model.addAttribute("orders",orders);
		List<VOrderDetail> orderDetailList = vOrderDetailRepository.findByOrderIdAndCustomerId(id, account.getUserId());
		model.addAttribute("orderDetails",orderDetailList);		
		return "orderHistoryDetail";
	}
	
	//欲しいものリスト画面を表示
	@GetMapping("/wishlist")
	public String wishList(Model model) {
		List<VWishList> wishListList =  vWishListRepository.findBycustomerId(account.getUserId());
		model.addAttribute("wishListList",wishListList);				
		return "wishList";
	}
	
	//アカウント情報の確認画面を表示
	@GetMapping("/account")
	public String accountSetting(Model model) {
		String name = account.getUserName();
		String email = account.getUserEmail();
		model.addAttribute("name",name);				
		model.addAttribute("email",email);				
		return "accountRelogin";
	}
	
	@PostMapping("/account/setting")
	public String relogin(
		@RequestParam(name = "password",  defaultValue = "") String password,
		Model model) {
		List<Customer> customerList = customerRepository.findByEmailAndPassword(account.getUserEmail(), password);
		if(password == null || password.length() == 0) {
			model.addAttribute("message", "パスワードを入力してください");
			return "accountRelogin";
		}
		if(customerList.size() == 0 ) {
			// 存在しなかった場合
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "accountRelogin";
		}
		this.session.setAttribute("password", password);
		return "accountSetting";
	}
	
	@PostMapping("/account/setting/confirm")
	public String accountSettingConfirm(
			@RequestParam(name = "name" , defaultValue = "") String name,
			@RequestParam(name = "address" , defaultValue = "") String address,
			@RequestParam(name = "tel" , defaultValue = "") String tel,
			@RequestParam(name = "email",  defaultValue = "") String email,
			@RequestParam(name = "password",  defaultValue = "") String password,
			Model model) {
		Customer customer = new Customer(name, address, tel, email, password, account.getPoint);
		customerRepository.save(customer);
		return "accountDetail";
		
	}
	

}
