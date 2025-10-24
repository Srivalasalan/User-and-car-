package com.cars.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailValidator {
	
	public static boolean emailValidate(String mail) {
		
		String emailRegex="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern p=Pattern.compile(emailRegex);
		Matcher m =p.matcher(mail);
		return mail!=null && m.matches();
	}
	
	
	public static boolean pwdValidate(String pwd) {
		String pwdRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
		Pattern p = Pattern.compile(pwdRegex);
		Matcher m = p.matcher(pwd);
		return pwd!=null && m.matches();
	}

}
