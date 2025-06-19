package com.example.demo.form;

import lombok.Data;

//入力をしてもらうためのForm。
//hobbyがhtml.Formのためにboolean[]なところがPoint!!
@Data
public class InputForm {
	private String name;
	private String kana;
	private String gender;
	private boolean[] hobby;
	private String word;
}