# VSCT_test

Ce test est à l'attention de Voyages-SNCF Technologies. Pour voir les résultats produits par l'algorithme dans plusieurs cas de test, veuillez lancer la classe `src/productSorter/Main.java`. Vous pouvez consulter la Javadoc du projet via le fichier `doc/index.html`.


## Notes
Plusieurs stratégies de tri plus rapides ont été envisagées :
* On pourrait pré-trier les éléments comme les complémentaires immédiats par exemple (mettre les 9 avec les 1, les 8 avec les 2, etc.)

> cette méthode permet de raccourcir le temps de calcul mais augmente le nombre de boîtes utilisées, cela est d'autant plus visible sur une petite quantité de produits
* On pourrait opérer un tri de façon différente en prenant par exemple les produits de taille 9 et en en mettant un maximum avec des produits de taille 1, puis en mettant les éventuels 9 restants seuls; ensuite on prend les 8, on les met avec les 2 et s'il reste des 8 on cherche à les mettre avec des 1; de même avec les 7, on cherche à remplir la caisse avec 3 puis 2 et 1 puis 1...

> cette méthode a l'avantage de parcourir beaucoup moins de fois et de façon beaucoup moins complète le tableau `products`, ce qui rend l'algorithme plus rapide; cependant, elle est contraignante à coder et le code n'est pas très propre
