package com.reddit.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reddit.dto.SubRedditDto;
import com.reddit.model.SubReddit;
import com.reddit.repository.SubRedditRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubRedditService {

	private final SubRedditRepository subRedditRepository;

	@Transactional
	public SubRedditDto save(SubRedditDto subRedditDto) {
		SubReddit save = subRedditRepository.save(mapSubRedditDto(subRedditDto));
		subRedditDto.setId(save.getSubRedditId());
		return subRedditDto;
	}

	@Transactional(readOnly = true)
	public List<SubRedditDto> getAll() {
		return subRedditRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
		
	}

	private SubRedditDto mapToDto(SubReddit subReddit) {
		return SubRedditDto.builder().id(subReddit.getSubRedditId()).name(subReddit.getName())
				.description(subReddit.getDescription()).numberOfPosts(subReddit.getPosts().size()).build();
	}

	private SubReddit mapSubRedditDto(SubRedditDto subRedditDto) {
		return SubReddit.builder().name(subRedditDto.getName()).description(subRedditDto.getDescription()).build();

	}

}
