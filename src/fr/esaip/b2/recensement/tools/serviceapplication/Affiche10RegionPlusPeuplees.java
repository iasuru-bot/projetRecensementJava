package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Region;
import fr.esaip.b2.recensement.entities.Ville;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.utilitaires.CalculPopulation;
import fr.esaip.b2.recensement.tools.comparator.RegionPopulationComparator;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.*;

public class Affiche10RegionPlusPeuplees extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        //Création d'un set contenant tous les noms des régions
        //On peut faire avec l'objet Région mais cela crée un appel de fonction pour chaque ville donc grosses pertes de performance.
        Set<String> nomRegionExistante = new HashSet<>();
        for (Ville v : recensement.getVilles()) {
            nomRegionExistante.add(v.getNomRegion());
        }

        //Création d'une liste des régions existantes
        List<Region> regionExistante = new ArrayList<>();
        //calcul de la population pour chaque région + ajout dans la liste
        for (String nomRegion : nomRegionExistante) {
            regionExistante.add(CalculPopulation.calculHabitantsRegion(recensement, nomRegion, 0));
        }
        //Tri la liste en fonction du comparateur
        regionExistante.sort(new RegionPopulationComparator());

        //Ressort le classement
        CadreSortie.Cadre(" Voici les 10 régions les plus peuplées de France :");
        for (int i = 0; i < 10; i++) {
            Region region = regionExistante.get(i);
            System.out.println((i+1)+".La région "+region.getNomRegion()+ " "+ region.getCodeRegion()+ " a "+ region.getPopulationRegion()+" habitants");
        }
        System.out.println("####################################################################################################");
        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }
}
