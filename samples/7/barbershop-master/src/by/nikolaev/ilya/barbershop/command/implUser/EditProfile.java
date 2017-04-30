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

public class EditProfile implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		User userEditTemporary = getEditPart(request, response);
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute(NameParametr.ATR_USER);
		String page = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			user = userService.editProfile(user, userEditTemporary);
			httpSession.setAttribute("user", user);
			page = NamePage.CABINET_PAGE;
		} catch (ServiceException e) {
			throw new CommandNotFoundException();
		}
		return page;
	}

	private User getEditPart(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter(NameParametr.PRM_EDIT_USER_NAME);
		String surname = request.getParameter(NameParametr.PRM_EDIT_USER_SURNAME);
		String email = request.getParameter(NameParametr.PRM_EDIT_USER_EMAIL);

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);

		return user;
	}

}
