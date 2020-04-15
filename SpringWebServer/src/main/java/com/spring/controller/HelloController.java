package com.spring.controller;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.dto.HelloObject;

@Controller
public class HelloController {
	private AtomicLong counter = new AtomicLong();

	public HelloObject getHelloWordObject() {
		HelloObject hello = new HelloObject();
		hello.setMessage("Hi there! you are number " + counter.incrementAndGet());
		return hello;
	}

	@GetMapping("/")
	public String handleRequest(Model model) {
		// accessing hello-service
		HelloObject helloObject = getHelloWordObject();
		model.addAttribute("msg", helloObject.getMessage());
		model.addAttribute("time", LocalDateTime.now());
		return "hello-page";
	}
}