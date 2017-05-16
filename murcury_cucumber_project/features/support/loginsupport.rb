=begin

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

And(/^Log me out$/) do
  # This is for PIPELINE
  puts "Log out !!!"

  # Capybara.page.execute_script('sessionStorage.clear()')
  # Capybara.reset_session!
  # p "Couldn't log out. So resetting Capybara Browser Session!"
end

And(/^I click on Flight link from Deals panel$/) do
  # This is for PIPELINE
  puts "Click Flight Link !!!"

  # click_an_object_from_list(@luth.lnk_all_flights_deals, 'Flights')
end

=end