package eu.tl1.injection.tp;

public interface TextAnalyzer {

	public void processLine(String text);

	public Object getResult();

	public void reset();
	
}
