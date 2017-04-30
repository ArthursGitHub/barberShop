package by.nikolaev.ilya.barbershop.dao;

import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public interface RecordDAO {
	Record signInRecordForSignInUser(Record record) throws DAOException;

	Record signInRecord(Record record) throws DAOException;
}
