class LoginPage < SitePrism::Page

  set_url "/"

  # *****************  All_Logo_Elements  ******************* #

  # *****************  All_Field_Elements  ******************* #
  element :fld_register, ".mouseOut [href^='mercuryregister']"
  element :fld_user_id, "#email"
  element :fld_password, "[name='password']"
  element :fld_conf_password, "[name='confirmPassword']"

  # *****************  All_Button_Elements  ******************* #
  element :btn_submit, "[name='register']"

  # *****************  All_Drop_down_Elements  ******************* #
  element :ddl_country, "#cl-country"

  # *****************  All_Check_Boxes_Elements  ******************* #


  # *****************  All_Links_Elements  ******************* #
  element :lnk_country, ".ls-country"
  element :lnk_flights_deals, "#nav-menuitem-1-link"

  elements :lnk_all_flights_deals, "#nav-menuitem-1-content li a"
  # *****************  Local_Methods  *************#

end