package com.sports.academyproject.academycontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class SportsAcademyController {
	@GetMapping("academicsports")
	public List<String> getAllSports(){
		return Arrays.asList("cricket","basketboll","kabaddi");
	}

}
