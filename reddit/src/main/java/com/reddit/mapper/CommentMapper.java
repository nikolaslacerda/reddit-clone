package com.reddit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reddit.dto.CommentDto;
import com.reddit.model.Comment;
import com.reddit.model.Post;
import com.reddit.model.User;

@Mapper(componentModel = "spring")
public interface CommentMapper {

	@Mapping(target = "commentId", ignore = true)
	@Mapping(target = "text", source = "commentDto.text")
	@Mapping(target = "createdDate", expression="java(java.time.Instant.now())")
	@Mapping(target = "post", source = "post")
	@Mapping(target = "user", source = "user")
	Comment map(CommentDto commentDto, Post post, User user);
	
	@Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
	@Mapping(target = "postId", expression ="java(comment.getPost().getPostId())")
	CommentDto mapToDto(Comment comment); 
}
