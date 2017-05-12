require 'capybara'
require 'site_prism'
require 'rubygems'
require 'tiny_tds'
require 'selenium-webdriver'
require 'capybara/rspec/matchers'
require 'capybara-screenshot/cucumber'
require 'capybara/poltergeist' 
# We need this line only if we have poltergeist driver

require_relative 'testdata.rb'
# require_relative 'testutil.rb'

Capybara.default_max_wait_time = DEFAULT_TIMEOUT

Capybara.app_host = WEBSITE_URL

# Screenshot generation on failures
Capybara.save_and_open_page_path = './screenshots'
# Keep only the screenshots generated from the last failing test suite
Capybara::Screenshot.prune_strategy = :keep_last_run
# Keep up to the number of screenshots specified in the hash
# Capybara::Screenshot.prune_strategy = { keep: 20 }


# If you want to capture a screenshot while test executing
# Capybara::Screenshot.screenshot_and_save_page

# You don't need to use this below "World" while using require at the top
# require 'capybara'
# require 'capybara/rspec/matchers'

# World(Capybara::DSL)
# World(Capybara::RSpecMatchers)

# pass environment variables to control which browser is used for testing.
btype = ENV['BTYPE'] || 'phantomjs'

case btype.downcase
when 'chrome'
  # puts '-----------------Chrome is Running--------------------'
  # Initializing chrome driver
  Capybara.default_driver = :selenium
  Capybara.register_driver :selenium do |app|
    options = {
    :js_errors => false,
    :timeout => 360,
    :debug => false,
    :inspector => false,
    }
    Capybara::Selenium::Driver.new(app, :browser => :chrome)
  end

when 'firefox'
  # puts '-----------------Firefox is Running--------------------'
  Capybara.default_driver = :selenium
  Capybara.register_driver :selenium do |app|
    options = {
    :js_errors => true,
    :timeout => 360,
    :debug => false,
    :inspector => false,
    }
    Capybara::Selenium::Driver.new(app, :browser => :firefox)
  end

when 'safari'
  Capybara.default_driver = :selenium
  Capybara.register_driver :selenium do |app|
    options = {
    :js_errors => false,
    timeout => 360,
    :debug => false,
    :inspector => false,
    }
    Capybara::Selenium::Driver.new(app, :browser => :safari)
  end

when 'opera'
  Capybara.default_driver = :selenium
  Capybara.register_driver :selenium do |app|
    options = {
      :js_errors => false,
      :timeout => 360,
      :debug => false,
      :inspector => false,
    }
    Capybara::Selenium::Driver.new(app, :browser => :opera)
  end

when 'poltergeist'
  Capybara.default_driver = :selenium
  Capybara.register_driver :selenium do |app|
    options = {
      :js_errors => false,
      :timeout => 360,
      :debug => false,
      :phantomjs_options => ['--load-images=no', '--disk-cache=false'],
      :inspector => false,
    }
    Capybara::Poltergeist::Driver.new(app, options)
  end

when 'phantomjs'
  Capybara.default_driver = :selenium
  Capybara.register_driver :selenium do |app|
    client = Selenium::WebDriver::Remote::Http::Default.new
    client.timeout = 300 # instead of the default 60
    bob =  Capybara::Selenium::Driver.new(app, :browser => :phantomjs, desired_capabilities: { 'phantomjs.cli.args' => ['--ignore-ssl-errors=yes'] }, :http_client => client)
  end
end	

# # This will run only once before all tests
# Before do 
#   p TestUtil.record_start_time
#   $dunit ||= false  # have to define a variable before we can reference its value
#   return $dunit if $dunit   # bail if $dunit TRUE
  
#   # otherwise do this below.
#   $test_suite_start_time = TestUtil.record_start_time   
#   $dunit = true                            # don't do it again.
# end 

# # This will run before each scenario
# Before do |scenario|
#   TestUtil.record_start_time
#   Capybara.page.driver.browser.manage.window.resize_to(1280, 800)
# end 

# # This will run after each scenario
# After do |scenario|
#   TestUtil.record_end_time
#   TestUtil.print_scenario_execution_time

#   if scenario.failed?
#     p 
#     console_logs = Capybara.page.driver.browser.manage.logs.get("browser")
#     p "Browser JS Console Logs:--***************-- #{console_logs.to_s}--***************--"
#     # step 'log me out'
#   end #if
# end 

# $logged_in = false
# Before do |scenario|
#   Capybara.use_default_driver

#   login_step=/^I am logged into AMAZON email as "(.*?)" with password "(.*?)" successfully$/

#   if !$logged_in
#     step 'I am logged into AMAZON email as "subash.dutt.b@gmail.com" with password "Welcome001" successfully'

#   elsif $logged_in
#     p 'Do not log in as user is already logged in !!!'
#   end
# end

at_exit do

  p "Test Suite Execution Start Time: #{$test_suite_start_time} secs"
  # p "Test Suite Execution End Time: #{$test_suite_end_time} secs"
  TestUtil.print_framework_end_time
  Capybara.page.driver.quit
  # p 'Driver has been Killed As Test Suite execution is completed !!!'
end


