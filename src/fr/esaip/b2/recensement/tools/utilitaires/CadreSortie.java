package fr.esaip.b2.recensement.tools.utilitaires;

public class CadreSortie {
    //méthode permettant d'afficher un cadre de sortie avec des #
    public static void Cadre(String valeur){
        System.out.println("####################################################################################################");
        int valeurLongueur = valeur.length();
        int longueurCadre=100;
        int tabLongueur= (valeurLongueur/(longueurCadre-2))+1;

        String[] tab = new String[tabLongueur];
        StringBuilder suffixe= new StringBuilder();
        int j = 0;
        StringBuilder valeurBuilder = new StringBuilder(valeur);

        for (int i = 0; i < valeurLongueur; i+=(longueurCadre-2)) {
            if (valeurLongueur-i < (longueurCadre-2)){
                suffixe.append(" ".repeat((longueurCadre-2)+i - valeurLongueur));
                valeurBuilder.append(suffixe);
                tab[j]= valeurBuilder.substring(i, (i + (longueurCadre-2))) ;
            }
            else {
                tab[j] = valeurBuilder.substring(i, (i + (longueurCadre-2)));
            }
            j++;
        }
        for (String s : tab) {
            System.out.println("#" + s + "#");
        }
        System.out.println("####################################################################################################");
    }
}
