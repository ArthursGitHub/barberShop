package by.nikolaev.ilya.barbershop.command.news;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.bean.News;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;
import by.nikolaev.ilya.barbershop.service.NewsService;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class ShowAllNews implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		ArrayList<News> listNews = null;
		String page = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		NewsService newsService = serviceFactory.getNewsService();

		try {
			listNews = newsService.showAllNews();
			if (listNews != null) {
				HttpSession session = request.getSession();
				session.setAttribute(NameParametr.ATR_NEWS_LIST, listNews);
				page = NamePage.NEWS_PAGE;
			} else {
				page = NamePage.ERROR_PAGE;
			}
		} catch (ServiceException e) {
			throw new CommandNotFoundException();
		}

		return page;
	}

}
