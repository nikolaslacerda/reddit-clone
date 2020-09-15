package com.reddit.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reddit.dto.SubRedditDto;
import com.reddit.model.Post;
import com.reddit.model.SubReddit;

@Mapper(componentModel = "spring")
public interface SubRedditMapper {

	@Mapping(target = "numberOfPosts", expression = "java(mapPosts(subReddit.getPosts()))")
	SubRedditDto mapSubRedditToDto(SubReddit subReddit); 

	default Integer mapPosts(List<Post> numberOfPosts) {
		return numberOfPosts.size();
	}

	@InheritInverseConfiguration
	@Mapping(target = "posts", ignore = true)
	SubReddit mapDtoToSubReddit(SubRedditDto subRedditDto);
}
