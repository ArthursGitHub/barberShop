package by.nikolaev.ilya.barbershop.command.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;

public final class Localization implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		request.getSession(true).setAttribute(NameParametr.ATR_LOCAL, request.getParameter(NameParametr.ATR_LOCAL));

		// String page = request.getHeader("referer");

		String page = NamePage.INDEX_PAGE;
		return page;
	}

}
