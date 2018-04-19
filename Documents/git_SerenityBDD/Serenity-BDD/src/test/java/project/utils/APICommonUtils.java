package project.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class APICommonUtils {

	public final static String APISampleApplicationEndpoint = "http://localhost:8085/student/list";

	// Login Body Internal
	public static final HashMap<String, Object> reqTestBodyasMap = new HashMap<>();
	static {
		
    	ArrayList<String> courses = new ArrayList<String>();
    	courses.add("JAVA");
    	courses.add("C++");
		
		reqTestBodyasMap.put("firstName", "TestFirstName2");
		reqTestBodyasMap.put("lastName", "TestLastName2");
		reqTestBodyasMap.put("email", "TestEmail5_updated_4@email.com");
		reqTestBodyasMap.put("programme", "TestProgramme2");
		reqTestBodyasMap.put("courses", courses);
	}

	// Identify Body Internal
	public static final HashMap<String, Object> createIdentifyReqBodyasMap = new HashMap<>();
	static {
		createIdentifyReqBodyasMap.put("Token", "38c6whn7-cb3u-wpjn-4yd2-8l9dw26x_30251");
		createIdentifyReqBodyasMap.put("portCode", "JFK");
		createIdentifyReqBodyasMap.put("CarrierCode", "QR");
		createIdentifyReqBodyasMap.put("ScheduledEncounterPort", "JFK");
		createIdentifyReqBodyasMap.put("FlightNumber", "6278");
		createIdentifyReqBodyasMap.put("Destination", "ZZZ");
		createIdentifyReqBodyasMap.put("ScheduledEncounterDate", getCurrentDate());
		createIdentifyReqBodyasMap.put("PhotoDate", getCurrentDate());
	}

	public static String getCurrentDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String text = date.format(formatter);
		return text;
	}
}


