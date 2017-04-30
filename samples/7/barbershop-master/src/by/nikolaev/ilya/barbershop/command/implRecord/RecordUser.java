package by.nikolaev.ilya.barbershop.command.implrecord;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.bean.Record;
import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.command.exeption.CommandNotFoundException;
import by.nikolaev.ilya.barbershop.controller.NamePage;
import by.nikolaev.ilya.barbershop.service.RecordService;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.exeption.ServiceException;

public class RecordUser implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute(NameParametr.ATR_USER);
		String page = null;

		if (user != null) {
			Record record = packingRecordUser(request, response, user.getId());

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			RecordService recordService = serviceFactory.getRecordService();
			try {

				record = recordService.signInRecordForSignInUser(record);
				if (record != null) {
					page = NamePage.RECORD_PAGE;
				} else {
					page = NamePage.ERROR_PAGE;
				}

			} catch (ServiceException e) {
				// throw new CommandNotFoundException();
			}

			return page;

		} else {
			Record record = packingRecord(request, response);
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			RecordService recordService = serviceFactory.getRecordService();
			try {

				record = recordService.signInRecord(record);
				if (record != null) {
					page = NamePage.RECORD_PAGE;
				} else {
					page = NamePage.ERROR_PAGE;
				}

			} catch (ServiceException e) {
				throw new CommandNotFoundException();
			}

			return page;
		}

	}

	private Record packingRecord(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter(NameParametr.PRM_RECORD_NAME);
		String date = request.getParameter(NameParametr.PRM_RECORD_DATE);
		String time = request.getParameter(NameParametr.PRM_RECORD_TIME);
		String phone = request.getParameter(NameParametr.PRM_RECORD_PRONE);

		Record record = new Record();
		record.setName(name);
		record.setData(Date.valueOf(date));
		record.setTime(time);
		record.setPhone(phone);

		return record;
	}

	private Record packingRecordUser(HttpServletRequest request, HttpServletResponse response, int userId) {

		String name = request.getParameter(NameParametr.PRM_RECORD_NAME);
		String date = request.getParameter(NameParametr.PRM_RECORD_DATE);
		String time = request.getParameter(NameParametr.PRM_RECORD_TIME);
		String phone = request.getParameter(NameParametr.PRM_RECORD_PRONE);

		Record record = new Record();
		record.setName(name);
		record.setData(Date.valueOf(date));
		record.setTime(time);
		record.setPhone(phone);
		record.setUserId(userId);

		return record;
	}

}
