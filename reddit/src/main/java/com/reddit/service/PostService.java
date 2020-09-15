package com.reddit.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reddit.dto.PostRequest;
import com.reddit.dto.PostResponse;
import com.reddit.exceptions.PostNotFoundException;
import com.reddit.exceptions.SubRedditNotFoundException;
import com.reddit.mapper.PostMapper;
import com.reddit.model.Post;
import com.reddit.model.SubReddit;
import com.reddit.model.User;
import com.reddit.repository.PostRepository;
import com.reddit.repository.SubRedditRepository;
import com.reddit.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

	private final SubRedditRepository subRedditRepository;
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final AuthService authService;
	private final PostMapper postMapper;

	public void save(PostRequest postRequest) {
		SubReddit subReddit = subRedditRepository.findByName(postRequest.getSubRedditName())
				.orElseThrow(() -> new SubRedditNotFoundException(postRequest.getSubRedditName()));
		User currentUser = authService.getCurrentUser();
		System.out.println(subReddit);
		System.out.println(currentUser);
		postRepository.save(postMapper.map(postRequest, subReddit, currentUser));
	}
 
	@Transactional(readOnly = true)
	public PostResponse getPost(Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
		return postMapper.mapToDto(post);
	}

	@Transactional(readOnly = true)
	public List<PostResponse> getAllPosts() {
		return postRepository.findAll().stream().map(postMapper::mapToDto).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<PostResponse> getPostsBySubReddit(Long subRedditId) {
		SubReddit subReddit = subRedditRepository.findById(subRedditId)
				.orElseThrow(() -> new SubRedditNotFoundException(subRedditId.toString()));
		List<Post> posts = postRepository.findAllBySubReddit(subReddit);
		return posts.stream().map(postMapper::mapToDto).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<PostResponse> getPostsByUsername(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
		List<Post> posts = postRepository.findByUser(user);
		return posts.stream().map(postMapper::mapToDto).collect(Collectors.toList());
	}

}
