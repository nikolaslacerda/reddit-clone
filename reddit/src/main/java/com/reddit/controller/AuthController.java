package com.reddit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.dto.AuthenticationResponse;
import com.reddit.dto.LoginRequest;
import com.reddit.dto.RegisterRequest;
import com.reddit.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup") 
	public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) {
		authService.signUp(registerRequest);
		return new ResponseEntity<>("User registration successful", HttpStatus.OK);
	}

	@GetMapping("/accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token) {
		authService.verifyAccount(token);
		return new ResponseEntity<>("Account activate successfully", HttpStatus.OK);
	}

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}

}
