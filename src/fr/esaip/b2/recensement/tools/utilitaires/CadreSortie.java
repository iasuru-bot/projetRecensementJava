package fr.esaip.b2.recensement.tools.utilitaires;

public class CadreSortie {
    public static void Cadre(String valeur){
        System.out.println("############################################################");
        int valeurLongueur = valeur.length();
        int tabLongueur= (valeurLongueur/58)+1;
        String[] tab = new String[tabLongueur];
        StringBuilder suffixe= new StringBuilder();
        int j = 0;
        StringBuilder valeurBuilder = new StringBuilder(valeur);

        for (int i = 0; i < valeurLongueur; i+=58) {
            if (valeurLongueur-i < 58){
                suffixe.append(" ".repeat(58+i - valeurLongueur));
                valeurBuilder.append(suffixe);
                tab[j]= valeurBuilder.substring(i, (i + 58)) ;
            }
            else {
                tab[j] = valeurBuilder.substring(i, (i + 58));
            }
            j++;
        }
        for (String s : tab) {

            System.out.println("#" + s + "#");
        }
        System.out.println("############################################################");
    }
}
