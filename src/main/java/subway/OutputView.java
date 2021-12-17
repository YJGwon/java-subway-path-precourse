package subway;

public class OutputView {
	private static final String MAIN_TITLE = "##메인화면";
	private static final String MAIN_OPTION_SEARCH = "1. 경로 조회";
	private static final String MAIN_OPTION_QUIT = "Q. 종료";

	private static final String QUESTION_FUNCTION = "## 원하는 기능을 선택하세요.";

	public void printMain() {
		System.out.println(MAIN_TITLE);
		System.out.println(MAIN_OPTION_SEARCH);
		System.out.println(MAIN_OPTION_QUIT);
	}

	public void askFunction() {
		System.out.println(QUESTION_FUNCTION);
	}
}
