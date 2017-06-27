package productSorter;

/**
 * 	Test pour VSCT (Affichage des résultats)
 *  @author Cannelle Rb
 */
public class Main {
	  /**
	   *  Calcule le nombre de caisses réalisées (utilisé pour l'affichage des résultats)
	   *  
	   * @param sorted	le résultat du tri des caisses
	   * @return		le nombre de caisses résultant de ce tri
	   */
	  public static int getNombreCaisses(StringBuilder sorted) {
		  int nb = 1;
		  for (int i = 0; i<sorted.length(); i++) {
			  if (sorted.charAt(i) ==  '/')
				  nb++;
		  }
		  return nb;
	  }

	  public static void main (String[] args){
		 // Mise en place d'un tableau d'exemples  
		   
	     String[] test = {"163841689525773",
	                      "16384168952577142537685487999564612313276566679584623131313433522767655243425433461516",
	                      "11111111111",
	                      "",
	                      "",
	                      ""/*,
	                      ""*/};
	     
		 for (int i = 0; i < 100000/*0*/; i++) {
			 int temp = (int)(Math.random()*10);
			 if (temp == 0) {
				 temp = temp + 1;
			 }
			 
			 if (i < 5000) {
				 test[3] += temp;
			 }
			 if (i < 10000) {
				 test[4] += temp;
			 }
			 if (i < 100000) {
				 test[5] += temp;
			 }
			 //test[6] += temp;
		 }
	     
		 // Début du test
		 
	     System.out.println("--------------------------------------------");
	     System.out.println("TEST - XSPEEDIT");
	     System.out.println("--------------------------------------------");
		 System.out.println();
	     
	     for (int i = 0; i < test.length; i++) {
	    	 int boxSize = 10;     
	     
		     long start = System.nanoTime();
		     
		     ProductSorter productSorter = new ProductSorter(test[i], boxSize);
		     
		     long elapsedTime = System.nanoTime() - start;
		     
		     System.out.println("Le tri de " + test[i].length() + " produits dans des caisses de taille " + boxSize 
		    		 +  " (cf. valeurs de test) donne :");
		     System.out.println(productSorter.getResult());
		     System.out.println("\nNombre de caisses : " + getNombreCaisses(productSorter.getResult()));
		     System.out.println("Temps de calcul : " + elapsedTime/1000000000F + " s");
		     System.out.println();
		     System.out.println("--------------------------------------------");
		     System.out.println();
	     }
	 }

}
