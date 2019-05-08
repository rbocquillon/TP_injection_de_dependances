package eu.tl1.injection.tp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {
	
	//utilisation d'un MockTextAnalyzer pour réaliser un test unitaire d'un objet TextReader
	@Test
	public void test() {
		MockTextAnalyzer mta = new MockTextAnalyzer();
		TextReader reader = new TextReader(mta);
		assertEquals(42,reader.getResult());
	}
	
}
