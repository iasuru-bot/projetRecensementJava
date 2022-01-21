package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Departement;
import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.utilitaires.CalculPopulation;
import fr.esaip.b2.recensement.tools.comparator.DepartementPopulationComparator;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.*;

public class Affiche10DepartementPlusPeuples extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        //Création d'un set contenant tout les noms des départements
        //On peut faire avec l'objet département mais cela crée un appel de fonction pour chaque ville donc grosses pertes de performance.
        Set<String> codeDepartementExistant = new HashSet<>();
        for (Ville v : recensement.getVilles()) {
            codeDepartementExistant.add(v.getCodeDepartement());
        }

        //Création d'une liste des départements existants
        List<Departement> departementExistant = new ArrayList<>();

        //calcul de la population pour chaque département + ajout dans la liste
        for (String codeDepartement : codeDepartementExistant) {
            departementExistant.add(CalculPopulation.calculHabitantsDepartement(recensement, codeDepartement));
        }

        //Tri en fonction du comparateur
        departementExistant.sort(new DepartementPopulationComparator());

        //Ressort le classement des 10 premiers
        CadreSortie.Cadre("Voici les 10 départements les plus peuplés :");

        for (int i = 0; i < 10; i++) {
            Departement departement = departementExistant.get(i);
            System.out.println((i+1)+". Le département "+departement.getCodeDepartement()+" a "+departement.getPopulationDepartement()+" habitants");
        }
        System.out.println("####################################################################################################");
        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }
}
