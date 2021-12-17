package subway.view;

import java.util.List;

import subway.service.FunctionOption;
import subway.service.SearchOption;

public class OutputView {
	private static final String TITLE_MAIN = "## 메인화면";
	private static final String TITLE_SEARCH = "## 경로 기준";
	private static final String TITLE_RESULT = "## 조회 결과";

	private static final String QUESTION_FUNCTION = "## 원하는 기능을 선택하세요.";
	private static final String QUESTION_DEPARTURE = "## 출발역을 입력하세요.";
	private static final String QUESTION_DESTINATION = "## 도착역을 입력하세요.";

	private static final String OPTION_FORMAT = "%s. %s%n";
	private static final String ERROR_FORMAT = "[ERROR] %s%n";
	private static final String INFO_FORMAT = "[INFO] %s%n";
	private static final String TOTAL_DISTANCE_FORMAT = "[INFO] 총 거리: %dkm%n";
	private static final String TOTAL_TIME_FORMAT = "[INFO] 총 소요 시간: %d분%n";

	private static final String BORDER_LINE = "--";

	public void printMain() {
		System.out.println(TITLE_MAIN);
		for (FunctionOption option : FunctionOption.values()) {
			System.out.printf(OPTION_FORMAT, option.getCode(), option.getValue());
		}
	}

	public void printSearchOption() {
		printBlankLine();
		System.out.println(TITLE_SEARCH);
		for (SearchOption option : SearchOption.values()) {
			System.out.printf(OPTION_FORMAT, option.getCode(), option.getValue());
		}
	}

	public void printResult(List<String> path, int totalDistance, int totalTime) {
		printBlankLine();
		System.out.println(TITLE_RESULT);
		printTotalWeights(totalDistance, totalTime);
		printPath(path);
		printBlankLine();
	}

	public void askFunction() {
		printBlankLine();
		System.out.println(QUESTION_FUNCTION);
	}

	public void askDeparture() {
		printBlankLine();
		System.out.println(QUESTION_DEPARTURE);
	}

	public void askDestination() {
		printBlankLine();
		System.out.println(QUESTION_DESTINATION);
	}

	public void printError(Exception exception) {
		printBlankLine();
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}

	private void printBlankLine() {
		System.out.println();
	}

	private void printBorderLine() {
		System.out.printf(INFO_FORMAT, BORDER_LINE);
	}

	private void printTotalWeights(int totalDistance, int totalTime) {
		printBorderLine();
		System.out.printf(TOTAL_DISTANCE_FORMAT, totalDistance);
		System.out.printf(TOTAL_TIME_FORMAT, totalTime);
	}

	private void printPath(List<String> path) {
		printBorderLine();
		for (String stationName : path) {
			System.out.printf(INFO_FORMAT, stationName);
		}
	}
}
