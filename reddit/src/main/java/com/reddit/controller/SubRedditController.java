package com.reddit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.dto.SubRedditDto;
import com.reddit.service.SubRedditService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j 
public class SubRedditController {

	private final SubRedditService subRedditService; 

	@PostMapping
	public ResponseEntity<SubRedditDto> createSubReddit(@RequestBody SubRedditDto subRedditDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(subRedditService.save(subRedditDto));
	}

	@GetMapping
	public ResponseEntity<List<SubRedditDto>> getAllSubReddits() {
		return ResponseEntity.status(HttpStatus.OK).body(subRedditService.getAll());
	}
	
	@GetMapping("/{subRedditId}")
	public ResponseEntity<SubRedditDto> getSubReddit(@PathVariable Long subRedditId){
		return ResponseEntity.status(HttpStatus.OK).body(subRedditService.getSubReddit(subRedditId));	
	}
}
