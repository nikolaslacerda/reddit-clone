package com.reddit.controller;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.dto.PostRequest;
import com.reddit.dto.PostResponse;
import com.reddit.service.PostService;

import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/api/posts") 
@AllArgsConstructor
public class PostController {

	private final PostService postService; 

	@PostMapping
	public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
		postService.save(postRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostResponse> getPost(@PathVariable Long postId) {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getPost(postId));
	}

	@GetMapping("/")
	public ResponseEntity<List<PostResponse>> getAllPosts() {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
	}
	
	@GetMapping("/by-sub/{subRedditId}")
	public ResponseEntity<List<PostResponse>> getPostsBySubReddit(@PathVariable Long subRedditId) {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsBySubReddit(subRedditId));
	}
	
	@GetMapping("/by-user/{name}")
	public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsByUsername(name));
	}
}
