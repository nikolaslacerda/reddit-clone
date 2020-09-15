package com.reddit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reddit.dto.SubRedditDto;
import com.reddit.exceptions.SpringRedditException;
import com.reddit.mapper.SubRedditMapper;
import com.reddit.model.SubReddit;
import com.reddit.repository.SubRedditRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubRedditService {

	private final SubRedditMapper subRedditMapper;
	private final SubRedditRepository subRedditRepository;
	

	@Transactional
	public SubRedditDto save(SubRedditDto subRedditDto) { 
		SubReddit save = subRedditRepository.save(subRedditMapper.mapDtoToSubReddit(subRedditDto));
		subRedditDto.setSubRedditId(save.getSubRedditId());
		return subRedditDto;
	}

	@Transactional(readOnly = true)
	public List<SubRedditDto> getAll() {
		return subRedditRepository.findAll().stream().map(subRedditMapper::mapSubRedditToDto)
				.collect(Collectors.toList());
	}

	public SubRedditDto getSubReddit(Long subRedditId) {
		SubReddit subReddit = subRedditRepository.findById(subRedditId).orElseThrow(() -> new SpringRedditException("No SubReddit found with id " + subRedditId));
		return subRedditMapper.mapSubRedditToDto(subReddit);
	}
	
	

}
