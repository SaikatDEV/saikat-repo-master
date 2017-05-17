Given(/^Navigate to Mercury website$/) do
  @luth = LoginPage.new
  @luth.load

  # sleep(5) # This will resume Testing for 5 Secs
  @luth.wait_for_fld_register

  # This will Print the Text of Register Button
  p "Register Button Label Text: #{@luth.fld_register.text}"

  # This will Print the Current URL
  p "Current URL: #{@luth.current_url}"

  expect(@luth.current_url.upcase).to include WEBSITE_URL.upcase
end

Given(/^User register using userid as "([^"]*)" and password as "([^"]*)"$/) do |userid, password|
  @luth = LoginPage.new
  @luth.fld_register.click
  @luth.wait_for_btn_submit
  @luth.wait_for_fld_user_id
  @luth.fld_user_id.set userid
  @luth.fld_password.set password
  @luth.fld_conf_password.set password
  @luth.btn_submit.click

p "Current URL: #{@luth.current_url}"
  @luth = LandingPage.new
  @luth.wait_for_fld_logged_in_text
  expect(@luth.fld_logged_in_text.text.upcase).to include USER_NAME.upcase
end

Then(/^User is on the Landing Page$/) do
  @luth = LandingPage.new
  @luth.load
  @luth.wait_for_fld_register_successful
  expect(@luth.fld_register_successful.text.upcase).to include REGISTER_SUCCESSFUL.upcase
end

When(/^User click on Cruises link$/) do
  @luth = LandingPage.new
  @luth.wait_for_lnk_cruise
  expect(@luth).to have_lnk_cruise
  @luth.lnk_cruise.click
end

Then(/^User is on the Cruise Page$/) do
  @luth = CruisePage.new
  @luth.wait_for_fld_cruise_successful
  expect(@luth.fld_cruise_itinerary.text.upcase).to include "CRUISE"
end

