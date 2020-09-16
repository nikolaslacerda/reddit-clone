package com.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
	
    private Long postId;
    private String postName;
    private String url;
    private String description;
    private String userName;
    private String subRedditName;
    private Integer voteCount;
    private Integer commentCount;
    private String duration;
    
}