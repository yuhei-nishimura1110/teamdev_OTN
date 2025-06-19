package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.ConfirmationForm;
import com.example.demo.form.InputForm;
import com.example.demo.service.HobbyEditService;


@Controller
public class ConfirmationController {
	
	//ここでhobbyを編集するためのクラスを呼び出し。
	private final HobbyEditService hobbyEditService;
	
	public ConfirmationController(HobbyEditService hobbyEditService){
		this.hobbyEditService = hobbyEditService;
	}
	//前の画面からinputFormを受取
	@PostMapping("/confirmation")
	public String confirmation(@ModelAttribute InputForm inputForm,RedirectAttributes redirectAttributes,
			Model model) {
		//ConfirmationFormを生成。
		ConfirmationForm confirmationForm = new ConfirmationForm();
		//ConfirmationFormにinputFormから参照して値を代入。
		confirmationForm.setName(inputForm.getName());
		confirmationForm.setKana(inputForm.getKana());
		confirmationForm.setGender(inputForm.getGender());
		//htmlの性質上、選択により配列が最後まで帰らない事があるので、それをhobbyRevisionで戻し、HobbyUnionでString型で結合して代入
		confirmationForm.setHobby(hobbyEditService.HobbyUnion(hobbyEditService.HobbyRevision(inputForm.getHobby())));
		confirmationForm.setWord(inputForm.getWord());
		//modelで出力
		model.addAttribute("confirmationForm",confirmationForm);
		return "confirmation";
	}
}
