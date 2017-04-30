package by.nikolaev.ilya.barbershop.service;

import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public interface RecordService {
	Record signInRecordForSignInUser(Record record) throws ServiceException;

	Record signInRecord(Record record) throws ServiceException;
}
