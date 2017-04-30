package by.nikolaev.ilya.barbershop.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import by.nikolaev.ilya.barbershop.bean.News;
import by.nikolaev.ilya.barbershop.dao.NewsDAO;
import by.nikolaev.ilya.barbershop.dao.ConnectionData.ConnectionDataSource;
import by.nikolaev.ilya.barbershop.dao.exception.DAOException;

public class SQLShowAllNewsDAO implements NewsDAO {

	@Override
	public ArrayList<News> showAllNews() throws DAOException {
		ArrayList<News> listNews = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionDataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM news");

			while (resultSet.next()) {
				News news = new News();

				news.setId(resultSet.getInt(1));
				news.setTitle(resultSet.getString(2));
				news.setDate(resultSet.getDate(3));
				news.setContent(resultSet.getString(4));

				listNews.add(news);
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}

		return listNews;
	}

}
