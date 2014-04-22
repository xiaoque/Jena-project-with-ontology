package applications;

import tools.JenaEngine;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;

public class Jena6 {
	private Model model;
	private String file;

	Jena6(String path) {
		this.file = path;
		this.model = JenaEngine.readModel(file);

		this.model = JenaEngine.readInferencedModelFromRuleFile(model,
				"data/owlrules.txt");
		this.model = JenaEngine.readInferencedModelFromRuleFile(model,
				"data/jena6.txt");
	}

	public void readPersonAge() {
		String query = "PREFIX ns: <http://www.owl-ontologies.com/unnamed.owl#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?person ?age "
				+ "WHERE{"
				+ "?person rdf:type ns:PersonAge. ?person ns:age ?age." + "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}

	public void readActorMale() {
		String query = "PREFIX ns: <http://www.owl-ontologies.com/unnamed.owl#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?person ?gender "
				+ "WHERE{"
				+ "?person rdf:type ns:ActorMale. ?person ns:gender ?gender."
				+ "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}

	public void readEnglishMovie() {
		String query = "PREFIX ns: <http://www.owl-ontologies.com/unnamed.owl#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?movie ?year ?language "
				+ "WHERE{"
				+ "?movie rdf:type ns:EnglishMovie. ?movie ns:year ?year.  ?movie ns:language ?language ."
				+ "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}
}
