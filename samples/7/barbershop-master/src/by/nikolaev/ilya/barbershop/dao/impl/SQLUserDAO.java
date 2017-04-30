package by.nikolaev.ilya.barbershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.dao.SQLCommand;
import by.nikolaev.ilya.barbershop.dao.UserDAO;
import by.nikolaev.ilya.barbershop.dao.Connectiondata.ConnectionDataSource;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public class SQLUserDAO implements UserDAO {

	@Override
	public User singinUser(User user) throws DAOException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = ConnectionDataSource.getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_SIGN_IN_USER);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSurname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setLogin(rs.getString(5));

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return user;
	}

	@Override
	public User signupUser(User user, String securPasword) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {

			connection = ConnectionDataSource.getConnection();

			preparedStatement = connection.prepareStatement(SQLCommand.INSER_SIGN_UP_USER);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getLogin());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return user;
	}

	@Override
	public User editProfile(User user) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			connection = ConnectionDataSource.getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_EDIT_PROFILE);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return user;
	}

	@Override
	public User personalUserDataDAO(int userId) throws DAOException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection connection = null;
		User user = null;

		try {
			connection = ConnectionDataSource.getConnection();
			String sql = "SELECT u.user_id, u.user_name, u.user_surname, u.user_email, u.user_login, last_haircut.haircut_date FROM user AS u INNER JOIN registration_haircut AS last_haircut WHERE (u.user_id = 2) = last_haircut.user_id AND last_haircut.haircut_date = (SELECT max(registration_haircut.haircut_date) FROM registration_haircut)";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, userId);

			rs = preparedStatement.executeQuery();

			user = new User();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSurname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setLogin(rs.getString(5));
				user.setDataHaircut(rs.getDate(6));

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return user;

	}

}
