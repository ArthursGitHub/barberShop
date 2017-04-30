package by.nikolaev.ilya.barbershop.command;

import java.util.HashMap;
import java.util.Map;

import by.nikolaev.ilya.barbershop.command.administration.RegistrationHaircut;
import by.nikolaev.ilya.barbershop.command.administration.ShowUserList;
import by.nikolaev.ilya.barbershop.command.administration.SignInAdmin;
import by.nikolaev.ilya.barbershop.command.implrecord.RecordUser;
import by.nikolaev.ilya.barbershop.command.impluser.CabinetUser;
import by.nikolaev.ilya.barbershop.command.impluser.EditProfile;
import by.nikolaev.ilya.barbershop.command.impluser.Registration;
import by.nikolaev.ilya.barbershop.command.impluser.SignInUser;
import by.nikolaev.ilya.barbershop.command.impluser.SignOutUser;
import by.nikolaev.ilya.barbershop.command.localization.Localization;
import by.nikolaev.ilya.barbershop.command.news.AddNews;
import by.nikolaev.ilya.barbershop.command.news.NewsAddPage;
import by.nikolaev.ilya.barbershop.command.news.ShowAllNews;

public class CommandHelper {
	private static CommandHelper instance;
	private Map<String, Command> commands = new HashMap<String, Command>();

	public static CommandHelper getInstance() {
		if (instance == null) {
			instance = new CommandHelper();
		}
		return instance;
	}

	private CommandHelper() {
		commands.put(NameParametr.CMD_REGISTRATION, new Registration());
		commands.put(NameParametr.CMD_SIGN_IN, new SignInUser());
		commands.put(NameParametr.CMD_LOCALIZATION, new Localization());
		commands.put(NameParametr.CMD_RECORD, new RecordUser());
		commands.put(NameParametr.CMD_SIGN_OUT, new SignOutUser());
		commands.put(NameParametr.CMD_SHOW_USER_LIST, new ShowUserList());
		commands.put(NameParametr.CMD_SHOW_NEWS, new ShowAllNews());
		commands.put(NameParametr.CMD_ADD_NEWS, new AddNews());
		commands.put(NameParametr.CMD_SIGN_IN_ADMIN, new SignInAdmin());
		commands.put(NameParametr.CMD_ADD_EDIT_USER, new EditProfile());
		commands.put(NameParametr.CMD_PAGE_ADD_NEWS, new NewsAddPage());
		commands.put(NameParametr.CMD_REGISTRATION_HAIRCUT, new RegistrationHaircut());
		commands.put(NameParametr.CMD_SHOW_CABINET_USER, new CabinetUser());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		if (command != null) {
			return command;
		} else {
			return command;
		}
	}
}
