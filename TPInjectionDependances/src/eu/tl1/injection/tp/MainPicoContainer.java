package eu.tl1.injection.tp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.injectors.MultiInjection;

public class MainPicoContainer {

	public static void main(String[] args) { //tests d'utilisation du framework d'injection PicoContainer
		//initialisation de text pour les tests
		List<String> text = new ArrayList<String>();
		text.add("Ceci est la premier ligne");
		text.add("Ceci est la deuxieme ligne");
		text.add("Cette ligne termine le texte");
		
		//test : le TextAnalyzer de TextReader est un WordCounter
		DefaultPicoContainer container = new DefaultPicoContainer(new MultiInjection());
		container.addComponent(TextAnalyzer.class, WordCounter.class);
		container.addComponent(TextReader.class);
		TextReader reader = container.getComponent(TextReader.class);
		reader.scan(text);
		System.out.println(reader.getResult());
		
		//test : le TextAnalyzer de TextReader est un CharCounter
		DefaultPicoContainer container2 = new DefaultPicoContainer(new MultiInjection());
		container2.addComponent(TextAnalyzer.class, CharCounter.class);
		container2.addComponent(TextReader.class);
		TextReader reader2 = container2.getComponent(TextReader.class);
		reader2.scan(text);
		System.out.println(reader2.getResult());
		
		//test : le TextAnalyzer de TextReader est un WordIndexer
		DefaultPicoContainer container3 = new DefaultPicoContainer(new MultiInjection());
		container3.addComponent(TextAnalyzer.class, WordIndexer.class);
		container3.addComponent(TextReader.class);
		container3.addComponent(Set.class,LinkedHashSet.class); //on peut mettre le type de Set qu'on veut (TreeSet, HashSet, LinkedHashSet ...)
		//si on utilise un TreeSet, les mots dans l'index seront rangés dans l'ordre alphabétique
		//si on utilise un LinkedHashSet, les mots dans l'index seront rangés dans l'ordre d'insertion ... etc
		TextReader reader3 = container3.getComponent(TextReader.class);	
		reader3.scan(text);
		@SuppressWarnings("unchecked")
		Set<String> index = (Set<String>) reader3.getResult();
		for(String mot : index) {
			System.out.println(mot);
		}
	}

}
