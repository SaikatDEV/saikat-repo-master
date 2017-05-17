class CruisePage < SitePrism::Page

  set_url "/mercurycruise.php"

  # *****************  All_Logo_Elements  ******************* #

  # *****************  All_Field_Elements  ******************* #
  element :fld_cruise_successful, "table [src*='cruise_special']"
  element :fld_cruise_itinerary, ".style6"

  # *****************  All_Button_Elements  ******************* #


  # *****************  All_Drop_down_Elements  ******************* #


  # *****************  All_Check_Boxes_Elements  ******************* #


  # *****************  All_Links_Elements  ******************* #
  element :lnk_home, "a[href*='welcome']"
  element :lnk_flights, "a[href*='reservation']"
  element :lnk_cruise, "a[href*='cruise']"

  # *****************  Local_Methods  *************#

end