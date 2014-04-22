package applications;

import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class Jena1 {
	String filepath;
	String namespace;
	Model model;
	OntModel ontmodel;

	Jena1(String str) {
		this.namespace = "";
		this.filepath = str;
		this.model = ModelFactory.createDefaultModel();
		this.ontmodel = ModelFactory.createOntologyModel();
		this.setModel();
		this.setOntModel();
		if (model != null) {
			this.namespace = model.getNsPrefixURI("");
		} else {
			System.out.println("Error when reading model from ontology");
		}
	}

	public void readAllPersons() {
		OntClass cl = ontmodel.getOntClass(namespace + "Person");
		Property pname = model.getProperty(namespace + "name");
		for (ExtendedIterator i = cl.listInstances(); i.hasNext();) {
			OntResource c = (OntResource) i.next();
			System.out.println("name: " + c.getProperty(pname).getString());
		}
	}

	public void setModel() {
		// use the FileManager to find the input file
		InputStream in = FileManager.get().open(this.filepath);
		if (in == null) {
			System.out
					.println("Ontology file: " + this.filepath + " not found");
		}

		// read the RDF/XML file
		model.read(in, "");
		try {
			in.close();
		} catch (IOException e) {
		}
		
	}

	public void setOntModel() {
		InputStream in = FileManager.get().open(this.filepath);
		if (in == null) {
			System.out
					.println("Ontology file: " + this.filepath + " not found");
		}
		ontmodel.read(in, "");
		try {
			in.close();
		} catch (IOException e) {
		}
	}

}
