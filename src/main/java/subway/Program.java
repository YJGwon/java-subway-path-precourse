package subway;

import java.util.Scanner;

public class Program {
	private final OutputView outputView = new OutputView();
	private final InputValidator inputValidator = new InputValidator();
	private final Scanner scanner;

	private boolean running = true;

	public Program(Scanner scanner) {
		this.scanner = scanner;
	}

	public void run() {
		chooseFunction();
		if (running) {
			search();
		}
	}

	public boolean isRunning() {
		return running;
	}

	private void chooseFunction() {
		outputView.printMain();
		if (askFunction().equals(FunctionOption.QUIT.getCode())) {
			running = false;
		}
	}

	private void search() {
		String chosenOptionCode = chooseSearchOption();
		if (chosenOptionCode.equals(SearchOption.GO_BACK.getCode())) {
			return;
		}
		if (chosenOptionCode.equals(SearchOption.DISTANCE.getCode())) {
			//TODO: 최단거리 경로 탐색
		}
		if (chosenOptionCode.equals(SearchOption.TIME.getCode())) {
			//TODO: 최단시간 경로 탐색
		}
	}

	private String chooseSearchOption() {
		outputView.printSearchOption();
		return askSearchOption();
	}

	private String askFunction() {
		outputView.askFunction();
		try {
			return inputValidator.validateFunction(scanner.nextLine());
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return askFunction();
		}
	}

	private String askSearchOption() {
		outputView.askFunction();
		try {
			return inputValidator.validateSearchOption(scanner.nextLine());
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return askSearchOption();
		}
	}
}
