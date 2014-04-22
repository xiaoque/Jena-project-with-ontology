package ShowMovie;

import java.util.ArrayList;

import tools.JenaEngine;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class GetData {
	private Model model;
	private String namespace;
	private String file;

	public GetData() {
		namespace = "";
		file = "data/project.owl";
		setModel();
		if (model != null) {
			namespace = model.getNsPrefixURI("");
		}
	}

	public void setModel() {
		this.model = JenaEngine.readModel("data/project.owl");
	}
	
	public ArrayList getFilmData(String name, String property){
		Resource rs = model.getResource(namespace + name);
		Property p = model.getProperty(namespace + property);
		Property ptitle = model.getProperty(namespace + "title");
		Property pyear = model.getProperty(namespace + "year");
		Property plang = model.getProperty(namespace + "language");
		Property pnation = model.getProperty(namespace + "country");
		ArrayList result = new ArrayList();

		if ((rs != null) && (p != null)) {
			StmtIterator it = rs.listProperties(p);
			while (it.hasNext()) {
				Statement s = it.next();
				Resource re = s.getResource();
				String title = re.getProperty(ptitle).getString();
				Movie temp = new Movie(title);
				temp.setLanguage(re.getProperty(plang).getString());
				temp.setYear(re.getProperty(pyear).getString());
				temp.setNation(re.getProperty(pnation).getString());
				result.add(temp);
			}
			return result;
		} else {
			return result;
		}
	}
}
