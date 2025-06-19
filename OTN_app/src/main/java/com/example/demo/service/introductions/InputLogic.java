package com.example.demo.service.introductions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Introductions;
import com.example.demo.mapper.IntroductionsMapper;

@Service
public class InputLogic {
	@Autowired
	private IntroductionsMapper introductionsMapper;
	/*public InputLogic(IntroductionsMapper introductionsMapper) {
		this.introductionsMapper = introductionsMapper;
	}
	*/
	
	public Introductions getIntrodutions(String user_id) {
		Introductions searchIntroductions =new Introductions();
		searchIntroductions.setUser_id(user_id);
		return introductionsMapper.introductionsUserId(searchIntroductions);
	}
}