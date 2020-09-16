package com.reddit.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reddit.dto.VoteDto;
import com.reddit.exceptions.PostNotFoundException;
import com.reddit.exceptions.SpringRedditException;
import com.reddit.model.Post;
import com.reddit.model.Vote;
import com.reddit.model.VoteType;
import com.reddit.repository.PostRepository;
import com.reddit.repository.VoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoteService {

	private final VoteRepository voteRepository;
	private final PostRepository postRepository;
	private final AuthService authService;

	@Transactional
	public void vote(VoteDto voteDto) {
		Post post = postRepository.findById(voteDto.getPostId()).orElseThrow(
				() -> new PostNotFoundException("Post not found with id " + voteDto.getPostId().toString()));

		Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
				authService.getCurrentUser());

		if (voteByPostAndUser.isPresent() && voteByPostAndUser.get().getVoteType().equals(voteDto.getVoteType())) {
			throw new SpringRedditException("You have already " + voteDto.getVoteType() + "'d for this post");
		}

		if (VoteType.UPVOTE.equals(voteDto.getVoteType())) {
			post.setVoteCount(post.getVoteCount() + 1);
		} else {
			post.setVoteCount(post.getVoteCount() - 1);
		}

		voteRepository.save(mapToVote(voteDto, post));
		postRepository.save(post);

	}
	
	private Vote mapToVote(VoteDto voteDto, Post post) {
		return Vote.builder().voteType(voteDto.getVoteType()).post(post).user(authService.getCurrentUser()).build();
	}

}
