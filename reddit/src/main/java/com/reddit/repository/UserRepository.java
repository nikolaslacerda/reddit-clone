package com.reddit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reddit.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
