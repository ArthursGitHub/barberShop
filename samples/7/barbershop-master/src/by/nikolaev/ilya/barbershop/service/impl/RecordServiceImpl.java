package by.nikolaev.ilya.barbershop.service.impl;

import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.dao.RecordDAO;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;
import by.nikolaev.ilya.barbershop.dao.factory.DAOFactory;
import by.nikolaev.ilya.barbershop.service.RecordService;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;
import by.nikolaev.ilya.barbershop.service.validation.ValidateRecord;

public class RecordServiceImpl implements RecordService {

	@Override
	public Record signInRecordForSignInUser(Record record) throws ServiceException {
		if (!ValidateRecord.validateRecord(record)) {
			record = null;
		} else {
			DAOFactory daoFactory = DAOFactory.getInstance();
			RecordDAO recordDAO = daoFactory.getRecordDAO();
			try {
				record = recordDAO.signInRecordForSignInUser(record);
			} catch (DAOException e) {
				throw new ServiceException();
			}

		}
		return record;
	}

	@Override
	public Record signInRecord(Record record) throws ServiceException {
		if (!ValidateRecord.validateRecord(record)) {
			record = null;
		} else {
			DAOFactory daoFactory = DAOFactory.getInstance();
			RecordDAO recordDAO = daoFactory.getRecordDAO();
			try {
				record = recordDAO.signInRecord(record);
			} catch (DAOException e) {
				throw new ServiceException();
			}

		}
		return record;
	}

}
