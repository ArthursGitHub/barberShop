package by.nikolaev.ilya.barbershop.command.impluser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.UserService;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class SignInUser implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		User user = null;
		String page = null;

		String login = request.getParameter(NameParametr.PRM_USER_LOGIN);
		String password = request.getParameter(NameParametr.PRM_USER_PASSWORD);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			user = userService.singinUser(user);

			if (user.getId() != 0) {
				HttpSession session = request.getSession();
				session.setAttribute(NameParametr.ATR_USER, user);
				session.setAttribute(NameParametr.ATR_LOGGED_USER, true);
				page = NamePage.INDEX_PAGE;

			} else {
				page = NamePage.ERROR_PAGE;
			}
		} catch (ServiceException e) {
			throw new CommandNotFoundException();
		}
		return page;
	}

}
