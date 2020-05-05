package com.bookstore.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.user.model.User;
import com.bookstore.user.response.UserData;
import com.bookstore.user.response.UserResponse;
import com.bookstore.user.service.IUserService;

/***************************************************************************************************
 * UserController By using the object reference of Userservice class This Controller Has fuctionallity to register User,seller
 * and same User And Seller Login Functionallity  also activate user from email account, 
 *
 * @author Rupesh Patil
 * @version 1.0
 * @created 2020-04-11
 * @see {@link IUserService} implementation of all the required services & functionality
 * @see {@link UserResponse ,UserData} if there is any type of response it will reflect out
 * 
 ******************************************************************************************************/


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	IUserService service;
	/**
	 * */
	@PostMapping("/register")
	public ResponseEntity<UserResponse> registerUser(@RequestBody User user){
		user.setSeller(false);
		return service.register(user);
	}
	
	@PostMapping("/seller-register")
	public ResponseEntity<UserResponse> sellerRegister(@RequestBody User user){
		user.setSeller(true);
		return service.register(user);
	}
	
	
	@PutMapping("/activ/{token}")
	public ResponseEntity<UserResponse> activateUserAccount(@PathVariable("token")String token){
		return service.activateUser(token);
	}
	
	@PostMapping("/login/{email}")
	public ResponseEntity<Object> loginUser(@PathVariable("email") String email,@RequestHeader("password") String password) {
		return service.loginUser(email,password);
	}
	
	@PostMapping("/seller-login/{email}")
	public ResponseEntity<Object> sellerLogin(@PathVariable("email") String email,@RequestHeader("password") String password) {
		return service.loginAdmin(email,password);
	}
	
	@GetMapping("/{token}")
	public ResponseEntity<UserData> getUserById(@PathVariable("token") String token) {
		return service.getUserByID(token);
	}
	
}
