package eu.tl1.injection.tp;

public class CharCounter implements TextAnalyzer {

	protected int count;
	
	@Override
	public void processLine(String text) {
		count+=text.length();
	}

	@Override
	public Object getResult() {
		return count;
	}

	@Override
	public void reset() {
		count=0;
	}

}
