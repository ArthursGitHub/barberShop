package by.nikolaev.ilya.barbershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.dao.RecordDAO;
import by.nikolaev.ilya.barbershop.dao.SQLCommand;
import by.nikolaev.ilya.barbershop.dao.Connectiondata.ConnectionDataSource;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public class SQLRecordDAO implements RecordDAO {

	@Override
	public Record signInRecordForSignInUser(Record record) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			connection = ConnectionDataSource.getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.INSER_RECORD_FOR_HAIRCUT_FROM_USER);
			preparedStatement.setString(1, record.getName());
			preparedStatement.setDate(2, record.getData());
			preparedStatement.setString(3, record.getTime());
			preparedStatement.setString(4, record.getPhone());
			preparedStatement.setInt(5, record.getUserId());
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
		return record;
	}

	@Override
	public Record signInRecord(Record record) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {

			connection = ConnectionDataSource.getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.INSER_RECORD_FOR_HAIRCUT_WITHOUT_USER);
			preparedStatement.setString(1, record.getName());
			preparedStatement.setDate(2, record.getData());
			preparedStatement.setString(3, record.getTime());
			preparedStatement.setString(4, record.getPhone());
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return record;
	}

}
