/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package applications;

import java.awt.EventQueue;

import ShowMovie.MainFrame;



/**
 * @author DO.ITSUDPARIS
 */
public class Main {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		
		/**
		 * jena 1 
		 *
		Jena1 jena1 = new Jena1("data/project.owl");
		jena1.readAllPersons();
		 */
		
		/**
		 *  jena 2
		Jena2 jena2 = new Jena2("data/project.owl");
		jena2.ask("data/ask.txt");
		jena2.describe("data/describe.txt");
		jena2.readAllPerson("data/query.txt");
		jena2.construct("data/construct.txt");
		 */

		
		/**
		 * jena3    
		Jena3 jena3 = new Jena3("data/project.owl");
		jena3.readActor();
		*/
		
		/**
		 * jena4  
		Jena4 jena4 = new Jena4("data/project.owl");
		String title = jena4.getInput();
		jena4.searchMovie(title);
		*/
		
		/**
		 * jena5   
		Jena5 jena5 = new Jena5("data/project.owl");
		jena5.readActorDirector();
		*/
		
		/**
		 * jena 6 
				
		Jena6 jena6 = new Jena6("data/project.owl");
		jena6.readPersonAge();
		jena6.readActorMale();
		jena6.readEnglishMovie();
		*/
		
		/**
		 * part 5  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}
}
