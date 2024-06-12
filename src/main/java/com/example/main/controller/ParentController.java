package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.dto.ParentDto;
import com.example.main.entity.Parent;

import com.example.main.service.ParentService;

@RestController
@RequestMapping("/api")
public class ParentController {
	
	@Autowired
	ParentService service;
	
	@PostMapping("/post")
	public Parent post(@RequestBody ParentDto parentDto) {
		return service.post(parentDto);
	}
	
	
	@PostMapping("/postAll")
	public List<ParentDto> postAll(@RequestBody List<ParentDto> dto){
		return service.postAll(dto);
	}
	
	
	@GetMapping("/get/{name}")
	public ParentDto get(@PathVariable String name) {
		return service.get(name);
	}
	
	@GetMapping("/getby/{key}")
	public List<Object> getAny(@PathVariable ("key")Object key){
		return service.getAny(key);
	}
	
	

}















