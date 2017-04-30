package by.nikolaev.ilya.barbershop.dao;

import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.News;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public interface NewsDAO {
	ArrayList<News> showAllNews() throws DAOException;

	News addNews(News news) throws DAOException;
}
