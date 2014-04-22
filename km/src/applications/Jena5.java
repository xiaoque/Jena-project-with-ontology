package applications;

import tools.JenaEngine;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;

public class Jena5 {
	private Model model;
	private String file;
	private String namespace;
	 
	Jena5(String path){
		this.namespace = "";
		this.file = path;
		this.model = JenaEngine.readModel(path);
		if(model != null ){
			namespace = model.getNsPrefixURI("");
		}
	}
	
	public void readActorDirector(){
		this.model = JenaEngine.readInferencedModelFromRuleFile(model, "data/owlrules.txt");
		this.model = JenaEngine.readInferencedModelFromRuleFile(model, "data/jena5.txt");
		
		String query = "PREFIX ns: <http://www.owl-ontologies.com/unnamed.owl#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?person  "
				+ "WHERE{"
				+ "?person rdf:type ns:ActorDirector. " + "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}

}
