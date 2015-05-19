package com.knowroaming.rfonseca.utils;

import java.util.regex.Pattern;

//Class to validate DataEntry
public class ValidationsUtils {

	
	public static boolean validateOnlyString(String value) {
	    final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
	    if (!pattern.matcher(value).matches()) {
	    	System.out.println("Invalid Name");
	    	return false;
	    }
		return true;
	}	
	
 
	public static boolean validateEmail(String value){
		final Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    if (!pattern.matcher(value).matches()) {
	    	System.out.println("Invalid Email");
	    	return false;
	    }
		return true;	
	}

	public static boolean validatePhoneNumber(String value){
		final Pattern pattern = Pattern.compile("\\d{10}");
	    if (!pattern.matcher(value).matches()) {
	    	System.out.println("Invalid Phone Number");
	    	return false;
	    }
		return true;	
	}

	public static boolean validateDateMask(String date){
		final Pattern pattern = Pattern.compile("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
	    if (!pattern.matcher(date).matches()) {
	    	System.out.println("Invalid Date format");
	    	return false;
	    }
		return true;	
	}	
	
	
	
}
