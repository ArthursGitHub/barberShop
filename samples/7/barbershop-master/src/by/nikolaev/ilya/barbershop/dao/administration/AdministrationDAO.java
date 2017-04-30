package by.nikolaev.ilya.barbershop.dao.administration;

import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.Admin;
import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public interface AdministrationDAO {
	ArrayList<User> ShowUserList() throws DAOException;

	Admin signInAdmin(Admin admin) throws DAOException;

	ArrayList<Record> showRegistrationHairCut() throws DAOException;
}
