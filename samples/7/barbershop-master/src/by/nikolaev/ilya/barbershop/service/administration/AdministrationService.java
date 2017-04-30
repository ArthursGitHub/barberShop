package by.nikolaev.ilya.barbershop.service.administration;

import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.Admin;
import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public interface AdministrationService {
	ArrayList<User> showUserList() throws ServiceException;

	Admin signInAdmin(Admin admin) throws ServiceException;

	ArrayList<Record> showUserRegistrationHairCut() throws ServiceException;
}
