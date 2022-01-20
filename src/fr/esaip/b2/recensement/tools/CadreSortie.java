package fr.esaip.b2.recensement.tools;

public class CadreSortie {
    public static void Cadre(String valeur){
        System.out.println("############################################################");
        int valeurLongueur = valeur.length();
        String sortie;
        String[] tab = new String[3];
        StringBuilder suffixe= new StringBuilder();
        if(valeurLongueur<=58){
            if (valeurLongueur < 58){
                suffixe.append(" ".repeat(58 - valeurLongueur));
            }
            sortie = "#" + valeur + suffixe + "#";
            System.out.println(sortie);
        }
        else if (valeurLongueur<=116){
            tab[0] = valeur.substring(0,58);
            tab[1] = valeur.substring(58,116);
            for (String s : tab) {
                sortie = "#" + s + "#";
                System.out.println(sortie);
            }

        }
        else {
            tab[0] = valeur.substring(0,58);
            tab[1] = valeur.substring(58);
            tab[2] = valeur.substring(116);
            for (String s : tab) {
                sortie = "#" + s + "#";
                System.out.println(sortie);
            }
        }
        System.out.println("############################################################\n");
    }
}
