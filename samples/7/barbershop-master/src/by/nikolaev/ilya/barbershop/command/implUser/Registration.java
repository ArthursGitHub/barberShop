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

public class Registration implements Command {
	/*
	 * � ����� ������ ����������� ����������� ������������ �������� ������ ��
	 * ������������ �������� �� � ������ User ����� ���� �������� � Service
	 * factory �������� ������ userService
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		User user = packingUser(request, response);
		String checkpassword = request.getParameter(NameParametr.PRM_USER_REGIST_PASSWORD);
		String page = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			user = userService.signupUser(user, checkpassword);

			if (user != null) {
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

	/* ������� ������������, �������� ������ � ���������� ��������� */
	private User packingUser(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter(NameParametr.PRM_USER_NAME);
		String surname = request.getParameter(NameParametr.PRM_USER_SURNAME);
		String email = request.getParameter(NameParametr.PRM_USER_EMAIL);
		String login = request.getParameter(NameParametr.PRM_USER_LOGIN);
		String password = request.getParameter(NameParametr.PRM_USER_PASSWORD);

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(password);

		return user;
	}
}
