package exception;

/**
 * Custom Exception for invalid operations
 *
 * @Author Wael AOUADI
 */
public class InvalidOperationException extends Exception {

	public InvalidOperationException(String message) {
		super(String.format(message));
	}
}
