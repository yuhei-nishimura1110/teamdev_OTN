package com.example.demo.form;

import lombok.Data;

//確認をして次に送るときに送りやすくするためだけのForm。
//hobbyがSQL同様StringなところがPoint!!
@Data
public class ConfirmationForm {
	private String name;
	private String kana;
	private String gender;
	private String hobby;
	private String word;
}
