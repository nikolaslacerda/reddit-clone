package com.reddit.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private Long commentId;
	private Long postId;
	private Instant createdDate;
	private String text;
	private String UserName;
}
