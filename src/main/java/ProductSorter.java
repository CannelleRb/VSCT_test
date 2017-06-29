package main.java;
import java.util.Arrays;

/**
 *  Tri des produits dans des caisses
 *  @see <a href="https://github.com/voyages-sncf-technologies/xspeedit" target="_top">Enoncé du test</a>
 *  @author Cannelle Rb
 *  
 *  @param products	            représentant le nombre d'occurrences de (i+1) dans la liste des produits à trier
 *  @param result	            contenant le résultat du tri des produits
 *  @param boxSize	            la taille des boîtes dans lesquelles on range les produits
 *  @param remainingProducts    le nombre de produits restant à trier
 */
public class ProductSorter {
	  private int[] products = new int[9];
	  private StringBuilder result = new StringBuilder();
	  private int boxSize;
	  private int remainingProducts;
	
	  /**
	   * Range les produits (products) dans des caisses (représentées dans result)
	   * 
	   * @param stringToSort	listant les produits à trier
	   * @param boxSize			la taille des boîtes dans lesquelles on range les produits
	   */
	  public ProductSorter(StringBuilder stringToSort, int boxSize) {
		  products = sortTab(stringToSort);
		  this.boxSize = boxSize;
		  remainingProducts = stringToSort.length();

		  this.complementarySort();
		  while (remainingProducts != 0) {
			  this.auxSort();
		  }
		  
		  if (result.length() > 0) {
		  	result.deleteCharAt(result.length()-1);
		  }
	  }
	  
	  /**
	   * Parcourt la liste (sous forme de String) des produits et renvoie un tableau t de taille 9, où t[i]
	   * représente le nombre d'occurrences de (i+1) dans tab 
	   *
	   * @param s	la chaîne de caractères à convertir en tableau
	   * @return	le tableau représentant les occurrences des produits
	  */
	  public static int[] sortTab(StringBuilder s) {
		  int[] t = new int[9];
		  Arrays.fill(t, 0);
		  for (int i = 0; i<s.length(); i++) {
			  t[Integer.parseInt(s.substring(i, i+1))-1] += 1;
		  }
		  return t;
	  }
	
	  /**
	  * Opère un premier tri et met ensemble tous les complémentaires immédiats : 9 et 1, 8 et 2, etc.
	  */
	  public void complementarySort() {
	  	int pSize = products.length;
		for (int i = 0; i <= pSize/2; i++) {
			/* vérifie si l'on est au milieu de la liste des produits ou pas (auquel cas on ajoute deux
			fois le même chiffre (5) et pas deux chiffres différents, ce qui change un peu la donne) */
			boolean middle = (i == pSize-i-1);
				
			/* le nombre de produits de chacun des deux complémentaires que l'on va ajouter en une seule 
			fois dans des caisses */
			int toBox;
				
			if (middle) {
				toBox = products[i]/2;
				products[i] -= toBox;
			}
			else {
				toBox = Math.min(products[i], products[pSize-i-1]);
				products[pSize-i-1] -= toBox;
			}
				
			products[i] -= toBox;
			remainingProducts -= 2*toBox;

			for (int j = 0; j < toBox; j++){
				result.append(Integer.toString(i+1) + Integer.toString(pSize-i) + "/");
			}
		}
	  }
	  
	  /**
	   * Crée les caisses de taille boxSize à partir du tableau products et les écrit dans result
	  */
	  public void auxSort() {
		  int boxContent = 0;
		  int i = products.length-1;

		  // tant qu'il reste des produits à ranger et que la boîte en cours n'est pas pleine
		  while (i >= 0 && boxContent != boxSize) {
			  /* tant qu'il reste des produits (i+1) et que (i+1) rentre dans la boîte, on 
			  l'y ajoute et on le retire du tableau products */
			  while (products[i] > 0 && i+1 <= boxSize - boxContent) {
				  result.append(Integer.toString(i+1));
				  boxContent += i+1;
				  products[i] -= 1;
				  remainingProducts -= 1;
			  }
			  i--;
		  }

		  // si la boîte en cours est pleine, on la ferme
		  if (boxContent == boxSize || i == -1) {
			  result.append("/");
		  }
	  }
	  
	  public StringBuilder getResult() {
		  return this.result;
	  }
}
