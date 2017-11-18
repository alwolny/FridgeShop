package pl.awolny.exceptions;


import org.springframework.security.core.AuthenticationException;

/**
 * Thrown if logging credentials belong to an inactive user.
 *
 */
public class UserNotActiveException extends AuthenticationException {
	/**
	 *
	 * @param msg the detail message.
	 */
	public UserNotActiveException(String msg) {
		super(msg);
	}

	/**
	 * @param msg the detail message.
	 * @param t root cause
	 */
	public UserNotActiveException(String msg, Throwable t) {
		super(msg, t);
	}
}