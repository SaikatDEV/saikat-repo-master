class TestUtil
  @start = nil
  @end = nil
  @complete = nil
  @execution_time = nil

  def self.record_start_time
    @start = Time.new
  end

  def self.record_end_time
    @complete = Time.new
  end

  def self.print_scenario_execution_time
    @execution_time = @complete - @start
    p "Scenario Completion Time: #{@execution_time} secs"
  end

  def self.print_framework_end_time
    @end = Time.new
    p "Test Suite Execution End Time: #{@end} secs"
  end
end