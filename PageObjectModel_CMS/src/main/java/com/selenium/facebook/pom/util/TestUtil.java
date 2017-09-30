package com.selenium.facebook.pom.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.selenium.facebook.pom.testcases.base.BaseTest;

public class TestUtil extends BaseTest{
	
	// returns current date and time
	public static String now(String dateFormat) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	    return sdf.format(cal.getTime());
	}

}