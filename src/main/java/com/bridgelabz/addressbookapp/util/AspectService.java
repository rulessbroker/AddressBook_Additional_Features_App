package com.bridgelabz.addressbookapp.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.bridgelabz.addressbookapp.model.AdderssBookModel;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class AspectService {
	@Before(value = "execution(* com.example.addressbookusingaop.Service.AddressBookService.*(..))")
	public void Before(JoinPoint joinPoint) {
		System.out.println("Before : " + joinPoint.getSignature().getName());
	}

	@Pointcut("execution(* com.example.addressbookusingaop.Service.AddressBookService.*(..))")
	public void loggingPointCut() {

	}

	@After(value = "execution(* com.example.addressbookusingaop.Service.AddressBookService.*(..))")
	public void After(JoinPoint joinPoint) {
		System.out.println("After : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(value = "execution(* com.example.addressbookusingaop.Service.AddressBookService.*(..))", returning = "addressBook")
	public void afterReturn(JoinPoint joinPoint, AdderssBookModel addressBook) {
		log.info("After :" + addressBook);
	}
}
