package by.nikolaev.ilya.barbershop.command.administration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.bean.Admin;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.administration.AdministrationService;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class SignInAdmin implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String page = null;
		Admin admin = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();

		try {
			admin = new Admin();
			admin.setLogin(loginAdmin(request, response));
			admin.setPassword(passwordAdmin(request, response));
			admin = administrationService.signInAdmin(admin);

			if ((admin.getId() != 0) && (admin.isStatus())) {
				HttpSession session = request.getSession();
				session.setAttribute(NameParametr.ATR_SUPER_USER, admin);
				session.setAttribute(NameParametr.ATR_LOGGED_ADMIN, true);
				page = NamePage.ADMIN_PAGE;
			} else {
				page = NamePage.ERROR_PAGE;
			}
		} catch (ServiceException e) {
			page = NamePage.ERROR_PAGE;
			e.printStackTrace();
		}

		return page;
	}

	private String loginAdmin(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter(NameParametr.PRM_ADMIN_LOGIN);
		return login;
	}

	private String passwordAdmin(HttpServletRequest request, HttpServletResponse response) {
		String passwprd = request.getParameter(NameParametr.PRM_ADMIN_PASSWORD);
		return passwprd;
	}

}
