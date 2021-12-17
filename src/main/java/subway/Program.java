package subway;

import java.util.Arrays;
import java.util.Objects;
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
		FunctionOption option = chooseFunctionOption();
		if (option == FunctionOption.QUIT) {
			running = false;
			return;
		}
		if (option == FunctionOption.SEARCH) {
			search();
		}
	}

	public boolean isRunning() {
		return running;
	}

	private FunctionOption chooseFunctionOption() {
		outputView.printMain();
		String optionCode = askFunction();
		return Arrays.stream(FunctionOption.values())
			.filter(option -> Objects.equals(option.getCode(), optionCode))
			.findFirst()
			.get();
	}

	private void search() {
		SearchOption option = chooseSearchOption();
		if (option == SearchOption.GO_BACK) {
			return;
		}
		String departure = askDeparture();
		String destination = askDestination();
		searcher.searchPath(departure, destination, option);
		try {
			inputValidator.validateTwoStation(departure, destination);
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			search();
		}
	}

	private SearchOption chooseSearchOption() {
		outputView.printSearchOption();
		String optionCode =  askSearchOption();
		return Arrays.stream(SearchOption.values())
			.filter(option -> Objects.equals(option.getCode(),optionCode))
			.findFirst()
			.get();
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
