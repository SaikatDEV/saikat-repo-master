# Helper Methods for page-objects cucumber
class HelperMethods
  # This method will select an object from lists and will perform click action
  def click_an_object_from_list(objects, text)
    objects.each do |item|
      if item.text.upcase.include? text.upcase
        item.click
        break
      end
    end
  end

  def count_of_an_object_list(objects)
    return objects.count
  end

  # Object existance will return true or false
  def text_exists_in_list(objects, text)
    objects.each do |item|
      if item.text.upcase.include? text.upcase
        return true
      end
    end
    false
  end

  # This method will get the text from lists
  def get_all_text_from_list(objects)
    objects.each do |item|
      item.text.upcase
    end
  end

  # Compare 2 array
  def compare_2array(first_object, second_object)
    value =  false
    first_object.each do |object|
      if object.to_a == second_object.to_a
        value = true
        break
      end
    end
    value
  end

  def verify_elements_size(objects, count)    
    10.times do
      i = objects.length
      if i == count
        break
      end
      sleep(0.5)
    end
  end

# def wait_until
#   require "timeout"
#   Timeout.timeout(Capybara.default_wait_time) do
#     sleep(0.1) until value = yield
#     value
#   end
# end

# def hover
#   @session.driver.browser.action.move_to(self.native).perform
# end

  def double_click_on(object)
    page.driver.browser.mouse.double_click(object.native)
  end

  def execute_query_MSSQLSERVER(sql_query, get_column_value)
    client = TinyTds::Client.new(
    :username => 'sa',
    :password => 'pass12',
    :dataserver => 'SaikatWin7-PC\MSSQLSERVER',
    :database => 'AdventureWorks2008R2',
    :timeout => 30
    )
    puts "Database connection openned? #{client.active?}"
    # puts client.active? # This will return true if the connection is exists
    result = client.execute(sql_query)

    result.each do |row|
      @value =  row[get_column_value]
    end
    
    client.close
    puts "Database connection closed? #{client.closed?}"
    return @value
  end

end

World do
  HelperMethods.new
end

