package eu.tl1.injection.tp;

public class WordCounter implements TextAnalyzer{

	protected int count;
	

	public void processLine(String text) {
		count += text.split(" ").length;
	}


	public Object getResult() {
		return count;
	}

	public void reset() {
		count = 0;	
	}

}
