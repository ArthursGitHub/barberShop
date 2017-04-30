package by.nikolaev.ilya.barbershop.service.impl;

import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.dao.UserDAO;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;
import by.nikolaev.ilya.barbershop.dao.factory.DAOFactory;
import by.nikolaev.ilya.barbershop.service.UserService;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;
import by.nikolaev.ilya.barbershop.service.validation.ValidationDate;

public class UserServiceImpl implements UserService {

	@Override
	public User singinUser(User user) throws ServiceException {
		if ((user.getLogin() != null) && (user.getPassword() != null)) {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();

			try {
				user = userDAO.singinUser(user);
			} catch (DAOException ex) {
				throw new ServiceException();
			}
		} else {
			throw new ServiceException();
		}
		return user;
	}

	@Override
	public User signupUser(User user, String securPasword) throws ServiceException {

		if (!ValidationDate.validationRegisterDate(user.getName(), user.getSurname(), user.getEmail(), user.getLogin(), user.getPassword(), securPasword)) {
			user = null;

		} else {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			try {
				user = userDAO.signupUser(user, securPasword);
			} catch (DAOException ex) {
				throw new ServiceException();
			}

		}
		return user;
	}

	@Override
	public User editProfile(User user, User userTempl) throws ServiceException {

		if ((userTempl.getName() != null) && (user.getSurname() != null) && (user.getEmail() != null)) {
			user.setName(userTempl.getName());
			user.setSurname(userTempl.getSurname());
			user.setEmail(userTempl.getEmail());

			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();

			try {
				user = userDAO.editProfile(user);
			} catch (DAOException e) {
				throw new ServiceException();
			}
		}

		return user;
	}

	@Override
	public User personalUserData(User user) throws ServiceException {
		int userId = user.getId();
		System.out.println(userId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();

		try {
			user = userDAO.personalUserDataDAO(userId);
		} catch (DAOException e) {
			throw new ServiceException();
		}

		return user;
	}

}
