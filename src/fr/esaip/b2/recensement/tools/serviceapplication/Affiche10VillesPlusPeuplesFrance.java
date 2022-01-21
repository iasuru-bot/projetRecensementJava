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
        System.out.println("Vous avez choisi nana");
        List<Ville> listeVilles=recensement.getVilles();
        listeVilles.sort(new VillesPopulationComparator());
        for (int i = 0; i < 10; i++) {
            String rep= ((i+1)+". "+listeVilles.get(i).getNomCommune()+" a "+listeVilles.get(i).getPopulationTotale()+" habitants");
            CadreSortie.Cadre(rep);
        }
        PressEnterToContinue.Press(scanner);
    }

}
