package subway;

import java.util.Scanner;

public class Program {
	private final OutputView outputView = new OutputView();
	private final InputValidator inputValidator = new InputValidator();
	private final Scanner scanner;

	public Program(Scanner scanner) {
		this.scanner = scanner;
	}

	public void run() {
		DataInitializer.init();
		outputView.printMain();
		String chosenFunction = chooseFunction();
		if (chosenFunction.equals(FunctionOption.QUIT.getCode())) {
			return;
		}
		outputView.printSearchOption();
	}


	private String chooseFunction() {
		outputView.askFunction();
		try {
			return inputValidator.validateFunction(scanner.nextLine());
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return chooseFunction();
		}
	}
}
