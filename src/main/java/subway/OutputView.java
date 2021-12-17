package subway;

public class OutputView {
	private static final String MAIN_TITLE = "## 메인화면";
	private static final String MAIN_OPTION_SEARCH = "1. 경로 조회";
	private static final String MAIN_OPTION_QUIT = "Q. 종료";

	private static final String SEARCH_TITLE = "## 경로 기준";
	private static final String SEARCH_OPTION_DISTANCE = "1. 최단 거리";
	private static final String SEARCH_OPTION_TIME = "2. 최소 시간";
	private static final String SEARCH_OPTION_GO_BACK = "B. 돌아가기";

	private static final String QUESTION_FUNCTION = "## 원하는 기능을 선택하세요.";

	private static final String ERROR_FORMAT = "[ERROR] %s%n";

	public void printMain() {
		System.out.println(MAIN_TITLE);
		System.out.println(MAIN_OPTION_SEARCH);
		System.out.println(MAIN_OPTION_QUIT);
	}

	public void printSearchOption() {
		System.out.println(SEARCH_TITLE);
		System.out.println(SEARCH_OPTION_DISTANCE);
		System.out.println(SEARCH_OPTION_TIME);
		System.out.println(SEARCH_OPTION_GO_BACK);
	}

	public void askFunction() {
		System.out.println(QUESTION_FUNCTION);
	}

	public void printError(Exception exception) {
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}
}
