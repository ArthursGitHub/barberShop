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

public class CabinetUser implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String page = null;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(NameParametr.ATR_USER);
		if (user.getId() != 0) {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userService = serviceFactory.getUserService();

			try {
				user = userService.personalUserData(user);
				if (user.getId() != 0) {
					session.setAttribute(NameParametr.ATR_USER, user);
					page = NamePage.CABINET_PAGE;
				} else {
					page = NamePage.ERROR_PAGE;
				}

			} catch (ServiceException e) {
				throw new CommandNotFoundException();
			}

		} else {
			page = NamePage.ADD_NEWS_PAGE;
		}
		return page;
	}

}
