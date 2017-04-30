package by.nikolaev.ilya.barbershop.service.impl;

import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.News;
import by.nikolaev.ilya.barbershop.dao.NewsDAO;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;
import by.nikolaev.ilya.barbershop.dao.factory.DAOFactory;
import by.nikolaev.ilya.barbershop.service.NewsService;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class NewsServiceImpl implements NewsService {

	@Override
	public ArrayList<News> showAllNews() throws ServiceException {
		ArrayList<News> listNews = null;
		DAOFactory daoFactory = DAOFactory.getInstance();
		NewsDAO newsDAO = daoFactory.getNewsDAO();

		try {
			listNews = newsDAO.showAllNews();
		} catch (DAOException e) {
			throw new ServiceException();
		}

		return listNews;
	}

	@Override
	public News addNews(News news) throws ServiceException {
		if ((news.getTitle() != null) && (news.getContent() != null)) {
			DAOFactory daoFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoFactory.getNewsDAO();

			try {
				news = newsDAO.addNews(news);
			} catch (DAOException e) {
				throw new ServiceException();
			}
		} else {
			throw new ServiceException();
		}

		return news;
	}

}
