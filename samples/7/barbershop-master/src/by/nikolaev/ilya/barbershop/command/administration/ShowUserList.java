package by.nikolaev.ilya.barbershop.command.administration;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.administration.AdministrationService;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class ShowUserList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		ArrayList<User> listUsers = null;
		String page = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();

		try {
			listUsers = administrationService.showUserList();
			if (listUsers != null) {
				HttpSession session = request.getSession();
				session.setAttribute(NameParametr.ATR_USERS_LIST, listUsers);
				page = NamePage.LIST_USERS_PAGE;
			} else {
				page = NamePage.ERROR_PAGE;
			}

		} catch (ServiceException e) {
			e.printStackTrace();
			page = NamePage.ERROR_PAGE;
		}

		return page;
	}

}
