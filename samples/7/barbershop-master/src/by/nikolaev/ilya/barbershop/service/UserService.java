package by.nikolaev.ilya.barbershop.service;

import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

/* this is interface used for Registracion, Sign In and edit profile*/
public interface UserService {
	User singinUser(User user) throws ServiceException;;

	User signupUser(User user, String pasword) throws ServiceException;;

	User editProfile(User user, User userTempl) throws ServiceException;

	User personalUserData(User user) throws ServiceException;
}
