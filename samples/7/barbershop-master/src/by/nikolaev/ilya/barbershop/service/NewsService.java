package by.nikolaev.ilya.barbershop.service;

import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.News;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public interface NewsService {

	ArrayList<News> showAllNews() throws ServiceException;

	News addNews(News news) throws ServiceException;

}
