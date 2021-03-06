class LandingPage < SitePrism::Page

  set_url "/create_account_success.php"

  # *****************  All_Logo_Elements  ******************* #

  # *****************  All_Field_Elements  ******************* #
  element :fld_logged_in_text, "table table table table p:nth-of-type(3)"
  element :fld_register_successful, "table table table table p:nth-of-type(2)"

  # *****************  All_Button_Elements  ******************* #


  # *****************  All_Drop_down_Elements  ******************* #


  # *****************  All_Check_Boxes_Elements  ******************* #


  # *****************  All_Links_Elements  ******************* #
  element :lnk_home, "a[href*='welcome']"
  element :lnk_flights, "a[href*='reservation']"
  element :lnk_cruise, "a[href*='cruise']"

  # *****************  Local_Methods  *************#

end