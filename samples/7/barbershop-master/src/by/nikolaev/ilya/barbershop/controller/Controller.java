package by.nikolaev.ilya.barbershop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.CommandHelper;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
	}

	protected void choiceRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommandHelper commondHelper = CommandHelper.getInstance();
		Command command = null;
		String page = null;
		String commandName = request.getParameter(NameParametr.PRM_COMMAND);

		try {
			command = commondHelper.getCommand(commandName);
			page = command.execute(request, response);
		} catch (CommandNotFoundException e) {
			page = NamePage.ERROR_PAGE;
		}
		if (page == null) {
			page = NamePage.INDEX_PAGE;
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		choiceRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		choiceRequest(request, response);
	}

}
