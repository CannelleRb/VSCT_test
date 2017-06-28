# VSCT_test

Ce test est à l'attention de Voyages-SNCF Technologies. Pour voir les résultats produits par l'algorithme dans plusieurs cas de test, veuillez lancer la classe `src/productSorter/Main.java`. Vous pouvez consulter la Javadoc du projet via le fichier `doc/index.html`.


## Notes
### Améliorations apportées
* L'élément déterminant pour améliorer le temps de calcul est l'utilisation de StringBuilder ; on observe que le temps de calcul est divisé par 100 environ entre l'utilisation de String et de concaténations classiques et l'utilisation de StringBuilder
* Une méthode de pré-tri (`complementarySort()`) a été ajoutée au tri de base (`auxSort()`), le gain de temps qu'elle offre est négligeable pour un petit nombre de produits mais augmente au fur et à mesure (de l'ordre de 0.001 seconde pour 10000 produits et 0.003 seconde pour 100000)

### Améliorations futures possibles
Une stratégie de tri plus rapide a été envisagée :
* On pourrait opérer un tri de façon différente en prenant par exemple les produits de taille 9 et en en mettant un maximum avec des produits de taille 1, puis en mettant les éventuels 9 restants seuls; ensuite on prend les 8, on les met avec les 2 et s'il reste des 8 on cherche à les mettre avec des 1; de même avec les 7, on cherche à remplir la caisse avec 3 puis 2 et 1 puis 1...

> cette méthode a l'avantage de parcourir beaucoup moins de fois et de façon beaucoup moins complète le tableau `products`, ce qui rend l'algorithme plus rapide; cependant, elle est contraignante à coder et le code n'est pas très propre
