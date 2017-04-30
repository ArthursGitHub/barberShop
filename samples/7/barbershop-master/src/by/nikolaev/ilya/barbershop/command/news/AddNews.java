package by.nikolaev.ilya.barbershop.command.news;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.nikolaev.ilya.barbershop.bean.News;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;
import by.nikolaev.ilya.barbershop.service.NewsService;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class AddNews implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		String page = null;
		News news = packingNews(request, response);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		NewsService newsService = serviceFactory.getNewsService();

		try {
			news = newsService.addNews(news);
			page = NamePage.ADD_NEWS_PAGE;

		} catch (ServiceException e) {
			throw new CommandNotFoundException();
		}

		return page;
	}

	private News packingNews(HttpServletRequest request, HttpServletResponse response) {
		String newsTitle = request.getParameter(NameParametr.PRM_NEWS_TITLE);
		Date newsDate = newsDate();
		String newsContent = request.getParameter(NameParametr.PRM_NEWS_CONTENT);

		News news = new News();
		news.setTitle(newsTitle);
		news.setDate(newsDate);
		news.setContent(newsContent);

		return news;
	}

	private Date newsDate() {
		Calendar newDay = new GregorianCalendar();
		int curent = newDay.get(Calendar.YEAR);
		int year = curent - 1900;
		int month = newDay.get(Calendar.MONTH);
		int day = newDay.get(Calendar.DAY_OF_MONTH);

		Date newDate = new Date(year, month, day);

		System.out.println(newDate);
		return newDate;
	}

}
