package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Aspect
@Component
public class CheckLoginAspect {
	
	@Autowired
	Account account;
	
	//Controllerクラスの全メソッド処理の前処理
	@Before("execution(* com.example.demo.controller.*Controller.*(..))")
	public void writelog(JoinPoint jp) {
		if (account == null || account.getUserName() == null || account.getUserPassword().length() == 0) {
			System.out.print("ゲスト");
		}else {
			System.out.print(account.getUserName() + ":");
		}
		
		System.out.println(jp.getSignature());
	}
	
	//AccountControllerクラス以外のControllerクラスで未ログインの場合はログインページにリダイレクト
	@Around("execution(* com.example.demo.controller.ItemController.*(..)) ||"
			+ "execution(* com.example.demo.controller.CartController.*(..)) ||"
			+ "execution(* com.example.demo.controller.ReviewController.*(..)) ||"
			+ "execution(* com.example.demo.controller.OrderController.*(..))")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable{
		if(account == null || account.getUserName() == null || account.getUserName().length() == 0) {
			System.err.println("ログインしていません！");
			return "redirect:/";
		}
		
		return jp.proceed();
	}

}
