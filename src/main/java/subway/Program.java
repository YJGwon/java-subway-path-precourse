package subway;

public class Program {
	private final OutputView outputView = new OutputView();

	public void run() {
		DataInitializer.init();
		outputView.printMain();
	}
}
