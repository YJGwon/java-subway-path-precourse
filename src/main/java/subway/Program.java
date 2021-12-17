package subway;

import java.util.Scanner;

public class Program {
	private final OutputView outputView = new OutputView();
	private final InputValidator inputValidator = new InputValidator();
	private final Scanner scanner;

	private Searcher searcher;

	private boolean running = true;

	public Program(Scanner scanner) {
		this.scanner = scanner;
	}

	public void initialiseData() {
		DataInitializer.init();
		this.searcher = new Searcher(
			DataInitializer.initDistanceGraph(), DataInitializer.initTimeGraph());
	}

	public void run() {
		chooseFunction();
		if (!running) {
			return;
		}
		collectDatasForSearch();
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

	private void collectDatasForSearch() {
		setSearchOption(chooseSearchOption());
		String departure = askDeparture();
		String destination = askDestination();
		try {
			inputValidator.validateTwoStation(departure, destination);
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			collectDatasForSearch();
		}
	}

	private void setSearchOption(String chosenOptionCode) {
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
		String input = scanner.nextLine();
		try {
			inputValidator.validateFunction(input);
			return input;
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return askFunction();
		}
	}

	private String askSearchOption() {
		outputView.askFunction();
		String input = scanner.nextLine();
		try {
			inputValidator.validateSearchOption(input);
			return input;
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return askSearchOption();
		}
	}

	private String askDeparture() {
		outputView.askDeparture();
		String input = scanner.nextLine();
		try {
			inputValidator.validateStationInput(input);
			return input;
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return askDeparture();
		}
	}

	private String askDestination() {
		outputView.askDestination();
		String input = scanner.nextLine();
		try {
			inputValidator.validateStationInput(input);
			return input;
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return askDestination();
		}
	}
}
