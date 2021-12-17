package subway;

import java.util.Arrays;

public class InputValidator {
	private static final String ERROR_MESSAGE_NO_SUCH_FUNCTION = "주어진 기능 내에서 선택해주세요(기호로 선택).";

	public String validateFunction(String input) {
		if (Arrays.stream(FunctionOption.values())
			.noneMatch(option -> input.equals(option.getCode()))) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_SUCH_FUNCTION);
		}
		return input;
	}

	public String validateSearchOption(String input) {
		if (Arrays.stream(SearchOption.values())
			.noneMatch(option -> input.equals(option.getCode()))) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_SUCH_FUNCTION);
		}
		return input;
	}
}
