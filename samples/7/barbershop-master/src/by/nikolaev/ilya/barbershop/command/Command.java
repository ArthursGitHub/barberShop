package by.nikolaev.ilya.barbershop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;

public interface Command {

	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException ;
}
