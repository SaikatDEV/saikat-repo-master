package com.selenium.facebook.pom.util;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;
import java.util.Date;

//	Report Implementation
//  To use Extent Reports below files needed
//	ExtentManager class
//	ReportsConfig.xml
//	pom.xml should has the dependency for this report



	public class ExtentManager {
		private static ExtentReports extent;
  
		public static ExtentReports getInstance(){
			
//			1st time this function is called, always will be null
//			Next time it will not null anymore So new report will append with the old
			if (extent == null) {
				
				Date d = new Date();
//				We want report filename to be generated with the Time stamp. So it will not over write the old
//				Replace colon with Underscore
				String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
      
//				Creating a new folder reports, if not exists
				File file = new File(FBConstants.REPORT_PATH);
				if (!file.exists()) {
					file.mkdirs();
				}
				
				String reportPath = FBConstants.REPORT_PATH + fileName;
      
//				Create an object of ExtentReports
				extent = new ExtentReports(reportPath, Boolean.valueOf(true), DisplayOrder.NEWEST_FIRST);
				extent.loadConfig(new File(FBConstants.REPORTS_CONFIG_PATH));
				extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo("Environment", "QA");
			}
			return extent;
		}
	}