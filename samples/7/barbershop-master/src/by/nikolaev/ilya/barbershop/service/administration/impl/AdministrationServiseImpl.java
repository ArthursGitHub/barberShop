package by.nikolaev.ilya.barbershop.service.administration.impl;

import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.Admin;
import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.dao.administration.AdministrationDAO;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;
import by.nikolaev.ilya.barbershop.dao.factory.DAOFactory;
import by.nikolaev.ilya.barbershop.service.administration.AdministrationService;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class AdministrationServiseImpl implements AdministrationService {

	@Override
	public ArrayList<User> showUserList() throws ServiceException {

		ArrayList<User> listUser = null;
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();

		try {
			listUser = administrationDAO.ShowUserList();
		} catch (DAOException e) {
			throw new ServiceException();
		}

		return listUser;
	}

	@Override
	public Admin signInAdmin(Admin admin) throws ServiceException {
		if ((admin.getLogin() != null) && (admin.getPassword() != null)) {
			DAOFactory daoFactory = DAOFactory.getInstance();
			AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();

			try {
				admin = administrationDAO.signInAdmin(admin);
			} catch (DAOException e) {
				throw new ServiceException();
			}
		} else {
			throw new ServiceException();
		}
		return admin;
	}

	@Override
	public ArrayList<Record> showUserRegistrationHairCut() throws ServiceException {
		ArrayList<Record> listUsers = null;

		DAOFactory daoFactory = DAOFactory.getInstance();
		AdministrationDAO administrationDAO = daoFactory.getAdministrationDAO();

		try {
			listUsers = administrationDAO.showRegistrationHairCut();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return listUsers;
	}

}
