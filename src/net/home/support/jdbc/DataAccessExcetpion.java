package net.home.support.jdbc;

public class DataAccessExcetpion extends RuntimeException {

	public DataAccessExcetpion() {
		super();
	}

	public DataAccessExcetpion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataAccessExcetpion(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAccessExcetpion(String message) {
		super(message);
	}

	public DataAccessExcetpion(Throwable cause) {
		super(cause);
	}
	
}
