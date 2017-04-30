package by.nikolaev.ilya.barbershop.command;

public class NameParametr {

	// For User
	public static final String PRM_USER_NAME = "user_name";
	public static final String PRM_USER_SURNAME = "user_surname";
	public static final String PRM_USER_EMAIL = "user_email";
	public static final String PRM_USER_LOGIN = "user_login";
	public static final String PRM_USER_PASSWORD = "user_password";
	public static final String PRM_USER_REGIST_PASSWORD = "user_regist_password";
	public static final String PRM_USER_STATUS = "user_status";

	// For Edit Profile
	public static final String PRM_USER_OLD_PASSWORD = "user_old_password";
	public static final String PRM_EDIT_USER_NAME = "edit_user_name";
	public static final String PRM_EDIT_USER_SURNAME = "edit_user_surname";
	public static final String PRM_EDIT_USER_EMAIL = "edit_user_email";

	// For Record users on A haircut
	public static final String PRM_RECORD_DATE = "record_date";
	public static final String PRM_RECORD_TIME = "record_time";
	public static final String PRM_RECORD_NAME = "record_name";
	public static final String PRM_RECORD_PRONE = "record_phone";

	// For new News
	public static final String PRM_NEWS_TITLE = "news_title";
	public static final String PRM_NEWS_CONTENT = "news_content";

	// CommandHelper
	public static final String CMD_REGISTRATION = "registration";
	public static final String CMD_SIGN_IN = "signin";
	public static final String CMD_LOCALIZATION = "localization";
	public static final String CMD_RECORD = "record";
	public static final String CMD_SIGN_OUT = "signout";
	public static final String CMD_SHOW_NEWS = "showAllNews";
	public static final String CMD_ADD_NEWS = "new_news";
	public static final String CMD_ADD_EDIT_USER = "editprofile";
	public static final String CMD_PAGE_ADD_NEWS = "page_add_news";
	public static final String CMD_SHOW_CABINET_USER = "cabinet";

	// Servlet
	public static final String PRM_COMMAND = "command";

	// Admin cmd
	public static final String CMD_SHOW_USER_LIST = "show_users";
	public static final String CMD_SIGN_IN_ADMIN = "signinAdmin";
	public static final String CMD_REGISTRATION_HAIRCUT = "registration_haircut";

	// admin prm
	public static final String PRM_ADMIN_LOGIN = "admin_login";
	public static final String PRM_ADMIN_PASSWORD = "admin_password";

	// session setAttribute

	public static final String ATR_RECORD_LIST = "record_list";
	public static final String ATR_USERS_LIST = "user_list";
	public static final String ATR_NEWS_LIST = "news_list";
	public static final String ATR_SUPER_USER = "superUser";
	public static final String ATR_LOGGED_ADMIN = "loggedAdmin";
	public static final String ATR_USER = "user";
	public static final String ATR_LOGGED_USER = "logged";
	public static final String ATR_LOCAL = "local";
}
