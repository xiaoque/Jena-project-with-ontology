package applications;

import java.io.Console;
import java.util.Scanner;

import tools.JenaEngine;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class Jena4 {
	private Model model;
	private String file;
	private String namespace;

	Jena4(String path) {
		this.namespace = "";
		this.file = path;
		this.model = JenaEngine.readModel(path);
		if (model != null) {
			namespace = model.getNsPrefixURI("");
		}
	}

	public String getInput() {
		System.out.println("Please enter a name of a movie: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public void searchMovie(String title) {
		if (hasMovie(title)) {
			Resource rs = model.getResource(namespace + title);
			System.out.println(rs.getLocalName());
			JenaEngine.readRsDataType(model, namespace, rs, "year");
			JenaEngine.readRsDataType(model, namespace, rs, "country");
			JenaEngine.readObjectType(model, namespace, title, "hasGenres");
			JenaEngine.readObjectType(model, namespace, title, "hasActor");
		} else {
			System.out.println("Error: Wrong title!");
		}
	}

	public boolean hasMovie(String title) {
		Resource rs = model.getResource(namespace + title);
		Property ptitle = model.getProperty(namespace + "title");
		if (rs != null && ptitle != null) {
			if(rs.getProperty(ptitle) != null )
				return true;
			else
				return false;
		}
		return false;
	}
}
