package test.java;

/**
 * 	Création de cas de test
 *  @author Cannelle Rb
 */
public class Test {
    /**
     *  Crée un tableau contenant des listes de produits à trier
     *
     * @return		un tableau de StringBuilder, chaque StringBuilder représentant une liste de produits à trier
     */
    public static StringBuilder[] createTests() {
        StringBuilder[] test = {new StringBuilder("163841689525773"),
                new StringBuilder("16384168952577142537685487999564612313276566679584623131313433522767655243425433461516"),
                new StringBuilder("11111111111"),
                new StringBuilder(),
                new StringBuilder(),
                new StringBuilder(),
                new StringBuilder()};

        for (int i = 0; i < 1000000; i++) {
            int temp = (int)(Math.random()*10);
            if (temp == 0) {
                temp = temp + 1;
            }

            if (i < 5000) {
                test[3].append(temp);
            }
            if (i < 10000) {
                test[4].append(temp);
            }
            if (i < 100000) {
                test[5].append(temp);
            }
            test[6].append(temp);
        }
        return test;
    }
}
