package subway;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO: 프로그램 구현
		Program program = new Program(scanner);
		program.initialiseData();
		while (program.isRunning()) {
			program.run();
		}
	}
}
