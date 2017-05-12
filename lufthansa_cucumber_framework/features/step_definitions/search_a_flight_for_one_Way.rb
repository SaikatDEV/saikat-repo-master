Given(/^I login to lufthansa website using userid as "(.*?)" and password as "(.*?)"$/) do |userid, password|
  # This is for PIPELINE
  puts "User has been Logged in !!!"

  # @luth = LoginPage.new
  # @luth.load
  # @luth.wait_until_fld_user_name_login_visible
  # @luth.fld_user_name_login.click
  # @luth.fld_user_id.set userid
  # @luth.fld_password.set password
  # @luth.wait_for_btn_login
  # @luth.btn_login.click
  # @luth.wait_until_lgo_plane_visible
  # expect(@luth.fld_user_name_login.text).to include(USER_NAME)

  # puts execute_query_MSSQLSERVER("SELECT top 1 * FROM [Person].[Person]", "FirstName")
end

Given(/^I select country as "([^"]*)" from top toolbar panel$/) do |country|
  # This is for PIPELINE
  puts "Country has been Selected !!!"

  # @luth = LoginPage.new
  # @luth.lnk_country.click
  # @luth.wait_until_btn_submit_country_visible
  # @luth.ddl_country.select country
  # @luth.btn_submit_country.click
  # @luth.wait_until_lgo_plane_visible
  # expect(@luth.lnk_country.text).to include(country)
end

When(/^I mouse hover on Flights and Deals option$/) do
  @luth = LoginPage.new
  @luth.wait_until_lnk_flights_deals_visible
  @luth.lnk_flights_deals.hover
  # This click method needed for phantomjs

  @luth.lnk_flights_deals.click 
  @luth.wait_for_lnk_all_flights_deals
  expect(verify_elements_size(@luth.lnk_all_flights_deals, 11)).to be(nil), \
  "Expected: 11, Got: #{@luth.lnk_all_flights_deals.length}" 

end

And(/^I click on Flight link from Deals panel$/) do
  # This is for PIPELINE
  puts "Click Flight Link !!!"

  # click_an_object_from_list(@luth.lnk_all_flights_deals, 'Flights')
end

Then(/^I will be able to see the new deals$/) do
  pending # Write code here that turns the phrase above into concrete actions
end

And(/^Log me out$/) do
  # This is for PIPELINE
  puts "Log out !!!"

  # Capybara.page.execute_script('sessionStorage.clear()')
  # Capybara.reset_session!
  # p "Couldn't log out. So resetting Capybara Browser Session!"

end