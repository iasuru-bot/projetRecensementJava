package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;
import fr.esaip.b2.recensement.tools.comparator.VillesPopulationComparator;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.*;

public class Affiche10VillesPlusPeuplesDepartement extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        CadreSortie.Cadre("Vous avez choisi d'afficher les 10 villes les plus peuplées d'un département\n 1- Saisir le code du département\n 2- Sortir");

        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée.");
        }
        switch (choix){
            case 1:
                CadreSortie.Cadre("Veuillez saisir le code du département souhaité:");
                //On récupère le nom du département avec exception gérée
                Scanner scan = new Scanner(System.in);
                String codeDepartement = null;
                try {codeDepartement = scan.nextLine();}
                catch (InputMismatchException e){
                    System.err.println("Vous n'avez pas saisi une bonne valeur.");
                }

                //Création d'une liste regroupant l'ensemble es listes du département
                List<Ville> villesDansDepartement= new ArrayList<>();
                boolean departementExiste=false;
                for (Ville v:recensement.getVilles()) {
                    if(v.getCodeDepartement().equals(codeDepartement)){
                        departementExiste = true;
                        villesDansDepartement.add(v);
                    }
                }

                //Tri en fonction du comparator
                villesDansDepartement.sort(new VillesPopulationComparator());

                //Ressort le classement
                int nombreVillesDansDepartement=villesDansDepartement.size();
                if (nombreVillesDansDepartement>10){nombreVillesDansDepartement=10;}
                if (departementExiste) {
                    CadreSortie.Cadre("Voici les 10 villes les plus peuplées du département " +codeDepartement+" :");
                    for (int i = 0; i < nombreVillesDansDepartement; i++) {
                        System.out.println((i + 1) + ". " + villesDansDepartement.get(i).getNomCommune() + " a " + villesDansDepartement.get(i).getPopulationTotale() + " habitants");
                    }
                    System.out.println("####################################################################################################");
                }
                else {System.err.println("Le département choisi n'existe pas");}
                break;

            case 2:
                break;

            default:
                CadreSortie.Cadre("Votre choix n'est pas bon.");

        }
        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }
}
