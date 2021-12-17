package subway;

public class OutputView {
	private static final String MAIN_TITLE = "##메인화면";
	private static final String MAIN_OPTION_SEARCH = "1. 경로 조회";
	private static final String MAIN_OPTION_QUIT = "Q. 종료";

	public void printMain() {
		System.out.println(MAIN_TITLE);
		System.out.println(MAIN_OPTION_SEARCH);
		System.out.println(MAIN_OPTION_QUIT);
	}
}
