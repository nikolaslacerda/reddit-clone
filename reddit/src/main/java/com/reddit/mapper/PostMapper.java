package com.reddit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reddit.dto.PostRequest;
import com.reddit.dto.PostResponse;
import com.reddit.model.Post;
import com.reddit.model.SubReddit;
import com.reddit.model.User; 

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "createdData", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "subReddit", source = "subReddit")
    @Mapping(target = "user", source = "user")
    Post map(PostRequest postRequest, SubReddit subReddit, User user); 

    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "subRedditName", source = "subReddit.name")
    PostResponse mapToDto(Post post);


}
