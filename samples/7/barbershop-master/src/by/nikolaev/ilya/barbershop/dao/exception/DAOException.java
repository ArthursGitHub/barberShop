package by.nikolaev.ilya.barbershop.dao.exception;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public DAOException(Exception e) {
	}

	public DAOException(String messages) {
		super(messages);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
