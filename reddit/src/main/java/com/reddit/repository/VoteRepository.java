package com.reddit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reddit.model.Post;
import com.reddit.model.User;
import com.reddit.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{

	Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User user);

}
