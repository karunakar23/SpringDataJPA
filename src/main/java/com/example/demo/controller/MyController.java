package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.User;
import com.example.demo.service.MyService;

@Controller
public class MyController {
	public MyService service;
	
	public MyController(MyService service) {
		this.service=service;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		System.out.println(user);
		this.service.createUserOrder(user);
		return new ResponseEntity<String>("Data is saved succesfully", HttpStatus.ACCEPTED);
	}
	@GetMapping("/userDetails/{id}")
	public ResponseEntity<User> getDetailsById(@PathVariable("id") int id){
		User resp=this.service.getById(id);
		User asli=new User();
		asli.setEmail(resp.getEmail());
		asli.setAddress(resp.getAddress());
		asli.setOrders(resp.getOrders());
		return new ResponseEntity<User>(asli, HttpStatus.ACCEPTED);
	}

}
