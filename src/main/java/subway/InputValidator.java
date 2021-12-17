package subway;

public class InputValidator {
	private static final String FUNCTION_OPTION_SEARCH = "1";
	private static final String FUNCTION_OPTION_QUIT = "Q";

	private static final String ERROR_MESSAGE_NO_SUCH_FUNCTION = "1, Q 중 하나를 입력하세요.";

	public String validateFunction(String input) {
		if (input.equals(FUNCTION_OPTION_SEARCH) || input.equals(FUNCTION_OPTION_QUIT)) {
			return input;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_NO_SUCH_FUNCTION);
	}
}
