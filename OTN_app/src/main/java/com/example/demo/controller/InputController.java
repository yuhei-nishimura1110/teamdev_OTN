package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Introductions;
import com.example.demo.form.InputForm;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.service.HobbyEditService;
import com.example.demo.service.introductions.InputLogic;
@Controller
public class InputController {
	//SQLを実行するためのInputLogicクラスと
	//Hobbyを編集するためのHobbyEditServiceクラスを呼び出し
	private final InputLogic inputLogic;
	private final HobbyEditService hobbyEditService;

	public InputController(InputLogic inputLogic,
			HobbyEditService HobbyEditService) {
		this.inputLogic = inputLogic;  
		this.hobbyEditService = HobbyEditService;
	}
	
	//ログイン者の情報を得るためにUserDatailsImplを受取
	@GetMapping("/input")
	public String input(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			Model model) {
		
		
		//テスト用にUserIdを入力してもらう。
		
		//System.out.println("テスト用にUserIDを入力してください。");
		//String userIdScanner = new Scanner(System.in).next();
		
		
		//テスト用にUser_Idを1固定で代入。
		
		String userIdScanner = "1";
		
		
		//テスト用に入力してもらったUserIdをselect
		
		Introductions introductions = inputLogic.getIntrodutions(userIdScanner);
		
		
		//ログイン者のIdを入手してselect
		
		//Introducions introducions = inputLogic.getIntrodutions(useDetailsImpl.getUser().getId());
		
		//InputFormを生成
		InputForm inputForm = new InputForm();
		
		//まだIntorducionsに登録していない→はじめての登録かの条件分岐
		if(introductions != null) {
			
			//すでに登録しているユーザーの情報をinputFormに突っ込む
			inputForm.setName(introductions.getName());
			inputForm.setKana(introductions.getKana());
			inputForm.setGender(introductions.getGender());
			//Hobbyに関しては文字列をboolean[]にする必要があるためHobbyResolusionを経由
			inputForm.setHobby(hobbyEditService.HobbyResolution(introductions.getHobby()));
			inputForm.setWord(introductions  .getWord());
			//inputFormをmodelとして出す
			model.addAttribute("inputForm",inputForm);
			return "input";
		}  else {
			
			//新規登録ゆーざーのinputFormにNullをそれぞれ突っ込んでいく
			inputForm.setName(null);
			inputForm.setKana(null);
			inputForm.setGender(null);
			//Hobbyに関してはboolean[]で作る必要があるためHobbyCreateで作成
			inputForm.setHobby(hobbyEditService.HobbyCreate());
			inputForm.setWord(null);
			//inputFormをmodelとして出す
			model.addAttribute("inputForm",  inputForm);
			return "input";
		}
	}

	//一度入力したデータをもう一度編集するためのコントローラー。InputFormを受けっ取っている
	@PostMapping("/input") 
	public String input(@ModelAttribute InputForm inputForm)  {
		return "input";
	}  
}  
   