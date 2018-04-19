package project.pages;

import net.thucydides.core.pages.PageObject;
import project.utils.HelperMethods;
import project.utils.Utilities;

/**
 * Page Object for Manifest Generator page
 * 
 * @author Saikat Barua
 *
 */

public class SamplePage extends PageObject {

	HelperMethods helper = new HelperMethods();
	public Utilities util = new Utilities();

/*
	
//	PAGE OBJECTs are located Here
//	*********************************HEADERs*******************************
	// Sample single element
	@FindBy(css = "span#firms_string")
	private WebElementFacade hdr_FirmsCode;
	
	@FindBy(css = "span#firms_string")
	private WebElementFacade hdr_Page_Element;
	
//	*********************************CONTAINERs***************************
	
//	*********************************MENUs*******************************
	
//	*********************************CHEKBOXs*******************************
	
//	*********************************FIELDs*******************************
	
//	*********************************TEXTFIELDs*******************************
	
//	*********************************BUTTONs*******************************
	// Sample list elements which is a collection of elements
	@FindBy(css = "#editEmailList ul a> span")
	private List<WebElementFacade> btn_Delete_Email_Lists;

	// Sample element with timeout built in 
	@FindBy(css = ".col-sm-8 #but-match-scans-create-exam-top", timeoutInSeconds="10")
	private WebElementFacade btn_Create_Exam_top;

//	*********************************FORMs*******************************
	
//	*********************************DDLs*******************************

	// Sample function
	public void samplePageRelatedFunction() {
		// To store value as session var and call it accross any classes
		Serenity.setSessionVariable("testuser").to("XXXXXX");
		String testUser = Serenity.sessionVariableCalled("testuser").toString().trim();
		
		// To wait for an element until 30 sec max
		hdr_Page_Element.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent();
		String elertEmailHeader = hdr_Elert_Email.getText().trim();

		// If else statement with collection elements
		if(priAlarmTyp.contains("NEUTRON") || (secAlarmTyp!=null && (secAlarmTyp.contains("NEUTRON")))) {
			helper.clickOnElementJS(rbn_LSS_Contacted_helps.get(1));
			Log.info("LSS has been selected as YES");
		}else {
			helper.clickOnElementJS(rbn_LSS_Contacted_helps.get(0));
			Log.info("LSS has been selected as NO");
		}

		// Verify button/text is not available in the elements collection
		helper.VerifyButtonIsNotAvailable(ctn_Exam_All_Actions, buttonValue);

		// Verify button/text is available in the elements collection
		helper.VerifyButtonIsAvailable(frm_Resolution_Tab, buttonValue);
		
		// To print the info in the execution console
		Log.info("Elert Email header is displaying as " + elertEmailHeader);

		// To click on ENTER button in the keyboard
		fld_Page_Element.waitUntilPresent().sendKeys(emailAddress, Keys.ENTER);
		
		// To select an option by value from Dropdown lists
		ddl_Lss_Contact_Name.selectByValue(lssContactPerson);

		// To click on an element
		btn_Edit_Email.waitUntilPresent().click();
		btn_Add_Comment.waitUntilClickable().click();

		// To click on element using Java Script
		helper.clickOnElementJS(btn_Done_Email);

		// To enter texts
		fld_LoginFilterBox.sendKeys("Some Texts");

		// To wait until the page refresh is completed for any Ajax req
		waitForWithRefresh();

		// To wait
		btn_Delete_Exam_Confirm.waitForCondition();

		// To wait for ignoring stale element error
		helper.ignoreStaleElementError(fld_Event_Summary, 15);

		// To convert any String into Integer value
		int scansCount1 =    Integer.valueOf(fld_Event_Summary_Num.getText().trim());

		// To click on an item from list elements
		helper.clickOnElemenByTextfromListElements(fld_Conveyance_Options, "some text");

		// To scroll into an element using JavaScript
		helper.scrollIntoViewJS(btn_Save_Exam);

		// To clear a text FIELD
		fld_Entry_Number.clear();

		// To implement Assertion
		boolean valueEmail = elertEmailHeader.contains("Alert Group Email (AGE) List");
		Assert.assertTrue("Page Email List header did not match", valueEmail);
	}

	// Sample function which is verifying multiple strings availability
	public void verifyMenuButtons(String button1, String button2, String button3) {
		btn_Refresh_Exam_top.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible();
		String[] expectedMenuButtons = {button1, button2, button3};
		boolean actualMenuButtons = helper.stringContainsItemFromList(btn_Headers_Menu, expectedMenuButtons );
		Assert.assertTrue("Expected Values: " + util.convertArrayToString(expectedMenuButtons), actualMenuButtons);
		Log.info("Pride menu button has been verified");	
	}


	public void verifySecondaryHeaders(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
		hdr_Secondary_Scan.waitUntilPresent();
		String[] expectedSecondaryScanHeaders = {arg1,arg2,arg3,arg4,arg5, arg6};
		boolean actualSecondaryScanHeaders = helper.stringContainsItemFromList(hdr_Secondary_Scan, expectedSecondaryScanHeaders );
		Assert.assertTrue("Expected Values: " + util.convertArrayToString(expectedSecondaryScanHeaders), actualSecondaryScanHeaders);
		Log.info("Secondary Scan/Alarm headers has been verified");	
	}

		public void selectPrimaryScans(int primarycount) {
		waitForWithRefresh();
		fld_Primary_RPM_Alarms_Count.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
		int primaryScanCount = Integer.parseInt(fld_Primary_RPM_Alarms_Count.getText().trim());
		if (primaryScanCount == 1) {
			primaryScanDate = flds_Primary_Scan_Dates.get(0).getText();
			
//			This will store the Alarm Type of the Primary Scan
			String primaryAlarmType = flds_Primary_Alarm_Types.get(0).getText().trim();
			Serenity.setSessionVariable("primaryAlarmType").to(primaryAlarmType);
			Log.info("Primary Alarm Type = " + primaryAlarmType);
			
			flds_Primary_Scan_Dates.get(0).click();
			Log.info("Primary Scan has been selected");	
		}else if(primaryScanCount > 1){
			int ElementIndex = util.getRandomNumber(0, primaryScanCount-1);
//			This will retrieve the Alarm Type of the Scan
			String primaryScanAlarmType = flds_Primary_Alarm_Types.get(ElementIndex).getText().trim();
			Serenity.setSessionVariable("priAlarmTyp").to(primaryScanAlarmType);
			Log.info("Selected Primary Alarm Type = " + primaryScanAlarmType);
			
			primaryScanDate = flds_Primary_Scan_Dates.get(ElementIndex).getText().trim();
			flds_Primary_Scan_Dates.get(ElementIndex).click();
			
			Log.info("Primary Scan has been selected");	
		}else if(primaryScanCount == 0){
			Log.info("There is no Alarms/Scans to Select !");
		}
	}
	
	public void selectSecondaryScans(int secondarycount) {
		waitForWithRefresh();
		List<WebElementFacade> SecondaryScanDateElements = flds_Secondary_Scan_Dates; 
		for(int i = 0; i < SecondaryScanDateElements.size(); i++ ) {
			SecondaryScanDateElements = flds_Secondary_Scan_Dates; 
			WebElementFacade secondaryScanDate = SecondaryScanDateElements.get(i);
			if(util.stringToDateFormatter(secondaryScanDate.getText().trim()).compareTo(util.stringToDateFormatter(primaryScanDate))>0) {
				
//				This will store the Alarm Type of the Secondary Scan
				String secondaryAlarmType = flds_Secondary_Alarm_Types.get(i).getText().trim();
				Serenity.setSessionVariable("secAlarmTyp").to(secondaryAlarmType);
				Log.info("Selected Secondary Alarm Type = " + secondaryAlarmType);
				
				secondaryScanDate.click();
				break;
			}
		}
		Log.info("Secondary Scan has been selected");	
	}
	

	public void loginToFacebook(String userid, String password) {
		// TODO Auto-generated method stub
		
	}
	
	*/
}
