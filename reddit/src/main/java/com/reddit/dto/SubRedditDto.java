package com.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubRedditDto {
	
	private Long subRedditId;
	private String name;
	private String description;
	private Integer numberOfPosts;

}
