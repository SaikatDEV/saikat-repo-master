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

Given(/^I can register using userid as "([^"]*)" and password as "([^"]*)"$/) do |userid, password|
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

