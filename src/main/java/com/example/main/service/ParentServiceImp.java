package com.example.main.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.Parent;
import com.example.main.dto.ParentDto;
import com.example.main.repository.ParentRepository;

@Service
public class ParentServiceImp implements ParentService {
	
	@Autowired
	ParentRepository parentRepo;

	@Override
	public Parent post(ParentDto parentDto) {
		Parent parent = new Parent();
		parent.setId(parentDto.getId());
		parent.setName(parentDto.getName());
		parent.setAge(parentDto.getAge());
		parent.setHeight(parentDto.getHeight());
		parent.setWeight(parentDto.getWeight());
		return parentRepo.save(parent);
	}


	@Override
	public List<ParentDto> postAll(List<ParentDto> dto) {
		List<Parent> entity=new ArrayList<>();
		for(ParentDto to:dto) {
			 Parent parent= new Parent();
			 parent.setId(to.getId());
			 parent.setName(to.getName());
			 parent.setAge(to.getAge());
			 parent.setHeight(to.getHeight());
			 parent.setWeight(to.getWeight());
			 entity.add(parent);
		}
		List<Parent> parent1=parentRepo.saveAll(entity);
		
		List<ParentDto> dto1= new ArrayList<>();
		for(Parent p:parent1) {
			ParentDto dto2 = new ParentDto();
			dto2.setId(p.getId());
			dto2.setName(p.getName());
			dto2.setAge(p.getAge());
			dto2.setHeight(p.getHeight());
			dto2.setWeight(p.getWeight());
			dto1.add(dto2);
		}	
		return dto1;
	}


	@Override
	public ParentDto get(String name) {
		Optional<Parent> entity=parentRepo.findByName(name);
		Parent parent=entity.get();
		ParentDto dto = new ParentDto();
		dto.setId(parent.getId());
		dto.setName(parent.getName());
		dto.setAge(parent.getAge());
		dto.setHeight(parent.getHeight());
		dto.setWeight(parent.getWeight());	
		return dto;
	}


	@Override
	public ParentDto findAllByParentQuery() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Object> getAny(Object key) {
		return parentRepo.findAnyKey(key);
		
	}

	

	
}











