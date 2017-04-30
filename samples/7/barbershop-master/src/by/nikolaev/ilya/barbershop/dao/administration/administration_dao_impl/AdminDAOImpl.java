package by.nikolaev.ilya.barbershop.dao.administration.administration_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.Admin;
import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.dao.SQLCommand;
import by.nikolaev.ilya.barbershop.dao.Connectiondata.ConnectionDataSource;
import by.nikolaev.ilya.barbershop.dao.administration.AdministrationDAO;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public class AdminDAOImpl implements AdministrationDAO {

	@Override
	public ArrayList<User> ShowUserList() throws DAOException {
		ArrayList<User> listUser = new ArrayList<>();
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionDataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_SHOW_ALL_USERS);

			while (resultSet.next()) {
				User user = new User();

				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setSurname(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setLogin(resultSet.getString(5));

				listUser.add(user);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return listUser;
	}

	@Override
	public Admin signInAdmin(Admin admin) throws DAOException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;

		try {
			connection = ConnectionDataSource.getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_SING_IN_ADMIN);
			preparedStatement.setString(1, admin.getLogin());
			preparedStatement.setString(2, admin.getPassword());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				admin = new Admin();
				admin.setId(resultSet.getInt(1));
				admin.setName(resultSet.getString(2));
				admin.setSurname(resultSet.getString(3));
				admin.setLogin(resultSet.getString(4));
				admin.setStatus(resultSet.getBoolean(6));

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return admin;
	}

	@Override
	public ArrayList<Record> showRegistrationHairCut() throws DAOException {
		ArrayList<Record> listRecord = new ArrayList<>();
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionDataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_SHOW_ALL_RGISTRATION_HAIRCUT);

			while (resultSet.next()) {
				Record record = new Record();

				record.setId(resultSet.getInt(1));
				record.setName(resultSet.getString(2));
				record.setData(resultSet.getDate(3));
				record.setTime(resultSet.getString(4));
				record.setPhone(resultSet.getString(5));
				record.setUserId(resultSet.getInt(6));
				listRecord.add(record);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return listRecord;
	}

}
