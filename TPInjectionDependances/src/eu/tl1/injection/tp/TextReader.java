package eu.tl1.injection.tp;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TextReader {
	
	protected TextAnalyzer analyzer;

	public TextReader(TextAnalyzer myanalyzer) {
		super();
		this.analyzer = myanalyzer;
	} 

	public void scan(List<String> text) {
		for (String line: text) {
			analyzer.processLine(line);
		}
	}
	
	public Object getResult() {
		return analyzer.getResult();
	}
	
	public void reset() {
		analyzer.reset();
	}
	
	public static void main(String[] args) {
		List<String> text = new ArrayList<String>();
		
		text.add("Ceci est la premier ligne");
		text.add("Ceci est la deuxieme ligne");
		text.add("Cette ligne termine le texte");
		
		WordCounter wc = new WordCounter();
		TextReader reader = new TextReader(wc);
		reader.scan(text);
		System.out.println(reader.getResult());

		CharCounter cc = new CharCounter();
		TextReader reader2 = new TextReader(cc);
		reader2.scan(text);
		System.out.println(reader2.getResult());
		
		WordIndexer wi = new WordIndexer(new TreeSet<String>());
		TextReader reader3 = new TextReader(wi);
		reader3.scan(text);
		wi.AfficheIndex();
	}
	
}