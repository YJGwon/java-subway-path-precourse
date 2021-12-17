package subway;

import java.util.Scanner;

public class Program {
	private final OutputView outputView = new OutputView();
	private final Scanner scanner;

	public Program(Scanner scanner) {
		this.scanner = scanner;
	}

	public void run() {
		DataInitializer.init();
		outputView.printMain();
		outputView.askFunction();
		scanner.nextLine();
	}
}
