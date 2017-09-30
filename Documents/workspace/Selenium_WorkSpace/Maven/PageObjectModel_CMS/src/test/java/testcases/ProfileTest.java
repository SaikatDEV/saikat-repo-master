package testcases;

import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LaunchPage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest {
	
	@Test
	public void testProfile(){
		
		LaunchPage lp = new LaunchPage();
		LoginPage loginPage =lp.gotoFBHomePage();
		loginPage.verifyTitle("Facebook Login");
		LandingPage landingPage = loginPage.doLogin("xx", "yy");
//		ProfilePage profPage= landingPage.gotoProfilePage();
//		profPage.verifyProfile();
		
		
	}

}
