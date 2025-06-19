package com.example.demo.service;

import org.springframework.stereotype.Service;


//このサービスクラスの役割。
//
//
//


@Service
public class HobbyEditService {
	public boolean[] HobbyResolution(String hobby) {
		String[] temporaryHobby = hobby.split(",");
		boolean[] reHobby = new boolean[9];
		for(int i = 0; i < 9; i++) {
			reHobby[i] = false;
			for(String j:temporaryHobby) {
				if(j.equals("項目" + String.valueOf(i + 1))) {
					reHobby[i] = true;
				}
			}
		}
		return reHobby;
	}
	
	public boolean[] HobbyRevision(boolean[] hobby) {
		int count = 0;
		boolean[] hobbyre = new boolean[9];
		for(int i = 0; i < 9; i++) {
			hobbyre[i] = false;
		}
		for(int i = 0; i < hobby.length; i++) {
			hobbyre[i] = hobby[i];
		}
		return hobbyre;
	}
	
	public String HobbyUnion(boolean[] hobby) {
		int count = 0;
		String reHobby = "";
		for(int i = 0; i < 9;i++) {
			if(hobby[i] == true && count == 0) {
				count++;
				reHobby += "項目" + String.valueOf(i + 1);
			}else if (hobby[i] == true && count ==1) {
				reHobby += ",項目" + String.valueOf(i + 1);
			}
		}
		return reHobby;
	}
	public boolean[] HobbyCreate() {
		boolean[] reHobby = new boolean[9];
		for(int i = 0; i < 9; i++) {
			reHobby[i] = false;
		}
		return reHobby;
	}
}