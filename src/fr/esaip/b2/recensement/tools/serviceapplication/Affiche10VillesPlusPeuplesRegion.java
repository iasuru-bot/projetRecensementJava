package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;
import fr.esaip.b2.recensement.tools.comparator.VillesPopulationComparator;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.*;

public class Affiche10VillesPlusPeuplesRegion extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        CadreSortie.Cadre("Vous avez choisi d'afficher les villes les plus peuplées d'une région.\n 1-Rentrer le nom de la région\n 2-Sortir");

        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix){
            case 1:
                CadreSortie.Cadre("Veuillez saisir le nom de la région souhaitée:");

                //Récupère le nom de la région
                Scanner scan = new Scanner(System.in);
                String nomRegion = null;
                try {nomRegion = scan.nextLine();}
                catch (InputMismatchException e){
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }

                //Liste des villes présentes dans une région
                List<Ville> villesDansRegion= new ArrayList<>();
                boolean regionExiste=false;
                for (Ville v:recensement.getVilles()) {
                    if(v.getNomRegion().equals(nomRegion)){
                        regionExiste = true;
                        villesDansRegion.add(v);
                    }
                }

                //Tri en fonction du comparator
                villesDansRegion.sort(new VillesPopulationComparator());

                //Ressort le classement
                int nombreVillesDansRegion=villesDansRegion.size();
                if (nombreVillesDansRegion>10){nombreVillesDansRegion=10;}
                if (regionExiste) {
                    CadreSortie.Cadre(" Voici les 10 villes les plus peuplées de "+nomRegion+" :");
                    for (int i = 0; i < nombreVillesDansRegion; i++) {
                        System.out.println((i + 1) + ". " + villesDansRegion.get(i).getNomCommune() + " a " + villesDansRegion.get(i).getPopulationTotale() + " habitants");
                    }
                    System.out.println("####################################################################################################");
                }
                else{System.err.println("La région choisie n'existe pas");}
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
