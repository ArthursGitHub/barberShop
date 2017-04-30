package by.nikolaev.ilya.barbershop.dao;

public class SQLCommand {

	// INSER INTO
	public static final String INSER_SIGN_UP_USER = "INSERT INTO user (user_name, user_surname, user_email, user_login, user_password) VALUES (?,?,?,?,?)";
	public static final String INSER_ADD_NEWS = "INSERT INTO news (news_title, news_date, news_content) VALUES (?,?,?)";
	public static final String INSER_RECORD_FOR_HAIRCUT_FROM_USER = "INSERT INTO registration_haircut (client_name, haircut_date, haircut_time, client_phone, user_id) VALUES (?,?,?,?,?)";
	public static final String INSER_RECORD_FOR_HAIRCUT_WITHOUT_USER = "INSERT INTO registration_haircut (client_name, haircut_date, haircut_time, client_phone) VALUES (?,?,?,?)";
	// UPDATE
	public static final String UPDATE_EDIT_PROFILE = "UPDATE user SET  user_name = ? , user_surname = ?, user_email = ? WHERE user_id = ?";

	// SELECT
	public static final String SELECT_SIGN_IN_USER = "SELECT * FROM user WHERE user_login = ? and user_password = ?";
	public static final String SELECT_SHOW_ALL_NEWS = "SELECT * FROM news ORDER BY news_id DESC";
	public static final String SELECT_SHOW_ALL_USERS = "SELECT * FROM user";
	public static final String SELECT_SING_IN_ADMIN = "SELECT * FROM super_user WHERE admin_login=? AND admin_password=?";
	public static final String SELECT_SHOW_ALL_RGISTRATION_HAIRCUT = "SELECT * FROM registration_haircut ORDER BY haircut_date DESC";
	public static final String SELECT_SHOW_USER_CABINET = "SELECT u.user_id, u.user_name, u.user_surname, u.user_email, u.user_login, last_haircut.haircut_date FROM user AS u"
			+ " INNER JOIN registration_haircut AS last_haircut WHERE (u.user_id = ?) = last_haircut.user_id " + "AND last_haircut.haircut_date = (SELECT max(registration_haircut.haircut_date) FROM registration_haircut)";
}
