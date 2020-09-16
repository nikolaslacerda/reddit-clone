package com.reddit.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reddit.exceptions.SpringRedditException;
import com.reddit.model.RefreshToken;
import com.reddit.repository.RefreshTokenRepoitory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {

	private final RefreshTokenRepoitory refreshTokenRepoitory;

	public RefreshToken generateRefreshToken() {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshToken.setCreatedDate(Instant.now());

		return refreshTokenRepoitory.save(refreshToken);
	}

	void validateRefreshToken(String token) {
		refreshTokenRepoitory.findByToken(token).orElseThrow(() -> new SpringRedditException("Invalid refresh Token"));
	}

	public void deleteRefreshToken(String token) {
		refreshTokenRepoitory.deleteByToken(token);
	}
}
