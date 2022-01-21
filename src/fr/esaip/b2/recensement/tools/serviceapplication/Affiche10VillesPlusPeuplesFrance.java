package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.comparator.VillesPopulationComparator;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.List;
import java.util.Scanner;

public class Affiche10VillesPlusPeuplesFrance extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        CadreSortie.Cadre(" Vous avez choisi d'afficher les 10 villes les plus peuplées de France.");
        //liste de toutes les villes de France
        List<Ville> listeVilles=recensement.getVilles();

        //Tri en fonction du comparator
        listeVilles.sort(new VillesPopulationComparator());

        //Ressort le classement
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1)+". "+listeVilles.get(i).getNomCommune()+" a "+listeVilles.get(i).getPopulationTotale()+" habitants");
        }
        System.out.println("####################################################################################################");

        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }

}
