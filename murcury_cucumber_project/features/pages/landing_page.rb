class LoginPage < SitePrism::Page

  set_url "/"

  # *****************  All_Logo_Elements  ******************* #
  element :lgo_plane, ".li.li-plane"

  # *****************  All_Field_Elements  ******************* #
  element :fld_register, ".mouseOut [href^='mercuryregister']"
  element :fld_user_id, "#lluserid"
  element :fld_password, "#llpassword"
  element :fld_user_name_login, "#header-profile-toggle"

  # *****************  All_Button_Elements  ******************* #
  element :btn_login, "#ll-btn"
  element :btn_submit_country, "#cl-form button"

  # *****************  All_Drop_down_Elements  ******************* #
  element :ddl_country, "#cl-country"

  # *****************  All_Check_Boxes_Elements  ******************* #


  # *****************  All_Links_Elements  ******************* #
  element :lnk_country, ".ls-country"
  element :lnk_flights_deals, "#nav-menuitem-1-link"

  elements :lnk_all_flights_deals, "#nav-menuitem-1-content li a"
  # *****************  Local_Methods  *************#

end