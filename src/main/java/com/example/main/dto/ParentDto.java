package com.example.main.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentDto {

	private int id;

	private String name;
	
	private int age;
	
	private int height;
	
	private double weight;
	
}
