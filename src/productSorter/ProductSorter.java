package productSorter;
import java.util.Arrays;

/**
 * 	Test pour VSCT
 *  @see <a href="https://github.com/voyages-sncf-technologies/xspeedit">Enoncé du test</a>
 *  @author Cannelle Rb
 *  
 *  @param products	représentant le nombre d'occurrences de (i+1) dans la liste des produits à trier
 *  @param result	contenant le résultat du tri des produits
 *  @param boxSize	la taille des boîtes dans lesquelles on range les produits
 *  @param remainingProducts le nombre de produits restant à trier
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
	  public ProductSorter(String stringToSort, int boxSize) {
		  products = sortTab(stringToSort);
		  this.boxSize = boxSize;
		  remainingProducts = stringToSort.length();

		  while (remainingProducts != 0) {
			  this.auxSort();
		  }
		  
		  if (result.length() > 0) {
		  	result.deleteCharAt(result.length()-1);
		  }
	  }
	  
	  /**
	   *  Parcourt la liste (sous forme de String) des produits et renvoie un tableau t de taille 9, où t[i]
	   * représente le nombre d'occurrences de (i+1) dans tab 
	   *
	   * @param s	la chaîne de caractères à convertir en tableau
	   * @return	le tableau représentant les occurrences des produits
	  */
	  public static int[] sortTab(String s) {
		  int[] t = new int[9];
		  Arrays.fill(t, 0);
		  for (int i = 0; i<s.length(); i++) {
			  t[Integer.parseInt(s.substring(i, i+1))-1] += 1;
		  }
		  return t;
	  }
	  
	  /**
	   *  Crée les caisses de taille boxSize à partir du tableau products et les écrit dans result
	  */
	  public void auxSort() {
		  int boxContent = 0;
		  int i = products.length-1;

		  // s'il reste des produits à ranger et que la boîte en cours n'est pas pleine
		  while (i >= 0 && boxContent != boxSize) {
			  /* si le produit (i+1) rentre dans la boîte, on l'y ajoute et on le retire
			  du tableau products */
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
