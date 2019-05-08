package eu.tl1.injection.tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WordIndexer implements TextAnalyzer {

	protected Set<String> index;
	
	public WordIndexer(Set<String> myset) {
		index = myset;
	}
	
	@Override
	public void processLine(String text) {
		String words[] = text.split(" ");
		List<String> mots = new ArrayList<String>();
		mots = Arrays.asList(words);
		for(String mot : mots) {
			if(!index.contains(mot)) {
				index.add(mot);
			}
		}
	}

	@Override
	public Set<String> getResult() {
		return index;
	}

	@Override
	public void reset() {
		index.clear();
	}

	public void AfficheIndex() {
		for(String mot : index) {
			System.out.println(mot);
		}
	}
	
}
