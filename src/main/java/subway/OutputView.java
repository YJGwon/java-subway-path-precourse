package subway;

public class OutputView {
	private static final String MAIN_TITLE = "## 메인화면";

	private static final String SEARCH_TITLE = "## 경로 기준";

	private static final String QUESTION_FUNCTION = "## 원하는 기능을 선택하세요.";

	private static final String OPTION_FORMAT = "%s. %s%n";
	private static final String ERROR_FORMAT = "[ERROR] %s%n";

	public void printMain() {
		System.out.println(MAIN_TITLE);
		for (FunctionOption option : FunctionOption.values()) {
			System.out.printf(OPTION_FORMAT, option.getCode(), option.getValue());
		}
	}

	public void printSearchOption() {
		System.out.println(SEARCH_TITLE);
		for (SearchOption option : SearchOption.values()) {
			System.out.printf(OPTION_FORMAT, option.getCode(), option.getValue());
		}
	}

	public void askFunction() {
		System.out.println(QUESTION_FUNCTION);
	}

	public void printError(Exception exception) {
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}
}
