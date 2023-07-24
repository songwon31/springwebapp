package com.mycompany.springwebapp.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springwebapp.dto.Ch04Form1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form1Validator implements Validator {
	
	//검사할 수 있는 객체인지 확인
	//supports 메서드의 리턴값이 true이어야만 validate 메서드가 실행된다.
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		//매개변수 clazz가 Ch04Form1과 동일하거나 하위 클래스인지(자동 타입변환이 가능한지) 검사
		boolean check = Ch04Form1.class.isAssignableFrom(clazz);
		return check;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04Form1 ch04Form1 = (Ch04Form1) target;
		
		//param1 검사
		String param1 = ch04Form1.getParam1();
		if (param1 == null || param1.equals("")) {
			errors.rejectValue("param1", "errors.form.required", "필수 입력(D)");
		} else if (param1.length() < 8) {
			errors.rejectValue("param1", "errors.form.minlength", new Object[] {8}, "최소 8자 이상 입력(D)");
		} else if (param1.length() > 15) {
			errors.rejectValue("param1", "errors.form.maxlength", new Object[] {15}, "최대 15자 이상 입력(D)");
		}
		
		//param2 검사
		String param2 = ch04Form1.getParam2();
		if (param2 == null || param2.equals("")) {
			errors.rejectValue("param2", "errors.form.required", "필수 입력(D)");
		} else {
			String regExp = "^(010|011)-[0-9]{3,4}-[0-9]{4}$";
			boolean result = Pattern.matches(regExp, param2);
			if (result == false) {
				errors.rejectValue("param2", "errors.form.format", "형식에 맞지 않음(D)");
			}
		}
		
		//param3 검사
		String param3 = ch04Form1.getParam3();
		if (param3 == null || param3.equals("")) {
			errors.rejectValue("param3", "errors.form.required", "필수 입력(D)");
		} else {
			String regExp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";
			boolean result = Pattern.matches(regExp, param3);
			if (result == false) {
				errors.rejectValue("param3", "errors.form.format", "형식에 맞지 않음(D)");
			}
		}
	}
}
