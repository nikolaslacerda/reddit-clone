package com.reddit.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.reddit.dto.PostRequest;
import com.reddit.dto.PostResponse;
import com.reddit.model.Post;
import com.reddit.model.SubReddit;
import com.reddit.model.User;
import com.reddit.model.Vote;
import com.reddit.model.VoteType;
import com.reddit.repository.CommentRepository;
import com.reddit.repository.VoteRepository;
import com.reddit.service.AuthService;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private AuthService authService;

	@Mapping(target = "createdData", expression = "java(java.time.Instant.now())")
	@Mapping(target = "description", source = "postRequest.description")
	@Mapping(target = "subReddit", source = "subReddit")
	@Mapping(target = "user", source = "user")
	@Mapping(target = "voteCount", constant = "0")
	@Mapping(target = "user", source = "user")
	public abstract Post map(PostRequest postRequest, SubReddit subReddit, User user);

	@Mapping(target = "postId", source = "postId")
	@Mapping(target = "postName", source = "postName")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "userName", source = "user.username")
	@Mapping(target = "url", source = "url")
	@Mapping(target = "subRedditName", source = "subReddit.name")
	@Mapping(target = "commentCount", expression = "java(commentCount(post))")
	@Mapping(target = "duration", expression = "java(getDuration(post))")
	@Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
	@Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
	public abstract PostResponse mapToDto(Post post);

	Integer commentCount(Post post) {
		return commentRepository.findByPost(post).size();
	}

	String getDuration(Post post) {
		return TimeAgo.using(post.getCreatedData().toEpochMilli());
	}

	boolean isPostUpVoted(Post post) {
		return checkVoteType(post, VoteType.UPVOTE);
	}

	boolean isPostDownVoted(Post post) {
		return checkVoteType(post, VoteType.DOWNVOTE);
	}

	private boolean checkVoteType(Post post, VoteType voteType) {
		if (authService.isLoggedIn()) {
			Optional<Vote> voteForPostByUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
					authService.getCurrentUser());
			return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType)).isPresent();
		}
		return false;
	}

}
