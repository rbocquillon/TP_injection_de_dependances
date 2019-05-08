package eu.tl1.injection.tp;

public class MockTextAnalyzer implements TextAnalyzer {

	@Override
	public void processLine(String text) {
	}

	@Override
	public Object getResult() {
		return 42;
	}

	@Override
	public void reset() {
	}

}
