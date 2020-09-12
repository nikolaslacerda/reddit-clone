package com.reddit.model;

public enum VoteType {
	UPVOTE(1), DOWNVOTE(-1);
	
	private int direction;

    VoteType(int direction) {
    }
  
}
