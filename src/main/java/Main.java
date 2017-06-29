package main.java;

import test.java.Test;
import test.java.Utils;

/**
 * 	Affichage des résultats
 *  @author Cannelle Rb
 */
public class Main {
	  public static void main (String[] args){
	     StringBuilder[] tests = Test.createTests();

         System.out.println("--------------------------------------------");
	     System.out.println("TEST - XSPEEDIT");
	     System.out.println("--------------------------------------------");
		 System.out.println();
	     
	     for (int i = 0; i < tests.length; i++) {
	    	 int boxSize = 10;     
	     
		     long start = System.nanoTime();
		     
		     ProductSorter productSorter = new ProductSorter(tests[i], boxSize);
		     
		     long elapsedTime = System.nanoTime() - start;
		     
		     System.out.println("Le tri de " + tests[i].length() + " produits dans des caisses de taille " + boxSize
		    		 +  " (cf. valeurs de test) donne :");
		     System.out.println(productSorter.getResult());
		     System.out.println("\nNombre de caisses : " + Utils.getNombreCaisses(productSorter.getResult()));
		     System.out.println("Temps de calcul : " + elapsedTime/1000000000F + " s");
		     System.out.println();
		     System.out.println("--------------------------------------------");
		     System.out.println();
	     }
	 }

}
