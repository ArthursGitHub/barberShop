package by.nikolaev.ilya.barbershop.command.impluser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;

public class SignOutUser implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {

		HttpSession session = request.getSession();
		session.removeAttribute(NameParametr.ATR_LOGGED_USER);
		session.removeAttribute(NameParametr.ATR_USER);
		String page = NamePage.INDEX_PAGE;
		return page;

	}

}
