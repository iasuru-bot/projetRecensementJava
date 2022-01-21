package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Region;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.utilitaires.CalculPopulation;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecherchePopulationRegion extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        CadreSortie.Cadre("Vous avez choisi de rechercher la population d'une région: \n 1-Rechercher par le nom d'une région \n 2-Rechercher par le code d'une région \n 3-Sortir");

        int choix = 0;
        try {
            choix = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix) {
            case 1:
                CadreSortie.Cadre("Vous avez choisi de rechercher par le nom d'une région \n Veuillez saisir le nom de la region recherché:");

                String nomRegion = null;
                try {
                    nomRegion = scanner.next();
                } catch (InputMismatchException e) {
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }

                Region region= CalculPopulation.calculHabitantsRegion(recensement,nomRegion,0);

                if (region!=null){

                    String rep =("La région "+region.getNomRegion()+ " "+ region.getCodeRegion()+ " a "+ region.getPopulationRegion()+" habitants");
                    CadreSortie.Cadre(rep);
                }
                else{
                    CadreSortie.Cadre("La région n'existe pas");
                }

                break;

            case 2:
                CadreSortie.Cadre("Vous avez choisi de rechercher par le code d'une région\nVeuillez saisir le code de la region recherché:");

                int codeRegion = 0;
                try {
                    codeRegion = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }

                region=CalculPopulation.calculHabitantsRegion(recensement,"",codeRegion);
                if (region!=null){
                    String rep =("La région "+region.getNomRegion()+ " "+ region.getCodeRegion()+ " a "+ region.getPopulationRegion()+" habitants");
                    CadreSortie.Cadre(rep);
                }
                else{
                    CadreSortie.Cadre("La région n'existe pas");
                }

                break;

            case 3:
                break;

            default:
                CadreSortie.Cadre("Votre choix n'est pas bon.");

        }
        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }

}
