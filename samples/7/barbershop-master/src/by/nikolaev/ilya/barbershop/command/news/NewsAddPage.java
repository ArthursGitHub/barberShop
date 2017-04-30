package by.nikolaev.ilya.barbershop.command.news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;

public class NewsAddPage implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String page = NamePage.ADD_NEWS_PAGE;

		return page;
	}

}
