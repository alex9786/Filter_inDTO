package com.example.main.service;

import java.util.List;

import com.example.main.dto.ParentDto;
import com.example.main.entity.Parent;

public interface ParentService {

	Parent post(ParentDto parentDto);

	ParentDto get(String name);

	List<ParentDto> postAll(List<ParentDto> dto);

	public ParentDto findAllByParentQuery();

	List<Object> getAny(Object key);
	
	
}
