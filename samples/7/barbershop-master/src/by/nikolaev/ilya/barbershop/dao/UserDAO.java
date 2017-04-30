package by.nikolaev.ilya.barbershop.dao;

import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public interface UserDAO {

	User singinUser(User user) throws DAOException;

	User signupUser(User user, String securPasword) throws DAOException;

	User editProfile(User user) throws DAOException;

	User personalUserDataDAO(int userId) throws DAOException;
}
