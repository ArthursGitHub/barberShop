package by.nikolaev.ilya.barbershop.command.administration;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.administration.AdministrationService;

public class RegistrationHaircut implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		ArrayList<Record> listRecords = null;
		String page = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdministrationService administrationService = serviceFactory.getAdministrationService();

		try {
			listRecords = administrationService.showUserRegistrationHairCut();
			if (listRecords != null) {
				HttpSession session = request.getSession();
				session.setAttribute(NameParametr.ATR_RECORD_LIST, listRecords);
				page = NamePage.REGISTRATION_HAIRCUT_PAGE;
			} else {
				page = NamePage.ERROR_PAGE;
			}
		} catch (Exception e) {

		}

		return page;
	}

}
