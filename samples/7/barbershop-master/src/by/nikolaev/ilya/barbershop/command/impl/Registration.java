package by.nikolaev.ilya.barbershop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.nikolaev.ilya.barbershop.bean.User;
import by.nikolaev.ilya.barbershop.command.Command;
import by.nikolaev.ilya.barbershop.command.NameParametr;
import by.nikolaev.ilya.barbershop.service.ServiceFactory;
import by.nikolaev.ilya.barbershop.service.UserService;

public class Registration implements Command {
	/*В днном методе выполняется регистрация пользователя
	 * полуяаем данный от пользователя Помещаем их в объект User после чего переходи в Service factory
	 *   получаем объект userService 
	 * */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = packingUser(request, response);
		String checkpassword = request.getParameter(NameParametr.PRM_USER_REGIST_PASSWORD);
		String page = null;
		
		ServiceFactory serviceFactory =  ServiceFactory.getInstance();/* получаем объект servisFactoy для предачи данных в сривсы */
		UserService userService = serviceFactory.getUserService();
		
		try {
			user = userService.signupUser(user, checkpassword);
			
			if(user != null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("logged", true);
				page = "index.jsp";
			}else{
				page = "error.jsp";
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return page;
	}
	/*Создаем пользователя, получаем данные и добовлдяем состояние*/
	private User packingUser(HttpServletRequest request, HttpServletResponse response){
		
		String name = request.getParameter(NameParametr.PRM_USER_NAME);
		String surname = request.getParameter(NameParametr.PRM_USER_SURNAME);
		String email = request.getParameter(NameParametr.PRM_USER_EMAIL);
		String login = request.getParameter(NameParametr.PRM_USER_LOGIN);
		String password = request.getParameter(NameParametr.PRM_USER_PASSWORD);
		
		
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(password);
		
		
		return user;
	}
}
