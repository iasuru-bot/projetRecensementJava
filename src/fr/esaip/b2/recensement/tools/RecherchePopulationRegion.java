package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Region;
import fr.esaip.b2.recensement.entities.Ville;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecherchePopulationRegion extends MenuService{
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {


        System.out.println("Vous avez choisi de rechercher la population d'une région:");
        System.out.println("1-Rechercher par le nom d'une région");
        System.out.println("2-Rechercher par le code d'une région");
        System.out.println("3-Sortir");

        int choix = 0;
        try {
            choix = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix) {
            case 1:
                System.out.println("Vous avez choisi de rechercher par le nom d'une région");
                System.out.println("Veuillez saisir le nom de la region recherché:");

                String nomRegion = null;
                try {
                    nomRegion = scanner.next();
                } catch (InputMismatchException e) {
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }

                Region region=CalculPopulation.calculHabitantsRegion(recensement,nomRegion,0);

                if (region.getPopulationRegion()!=0){
                    System.out.println("La région "+region.getNomRegion()+ " "+ region.getCodeRegion()+ " a "+ region.getPopulationRegion()+" habitants");
                }
                else{
                    System.out.println("La région n'existe pas");
                }

                break;

            case 2:
                System.out.println("Vous avez choisi de rechercher par le code d'une région");
                System.out.println("Veuillez saisir le code de la region recherché:");

                int codeRegion = 0;
                try {
                    codeRegion = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }

                region=CalculPopulation.calculHabitantsRegion(recensement,"",codeRegion);
                if (region.getPopulationRegion()!=0){
                    System.out.println("La région "+region.getNomRegion()+ " "+ region.getCodeRegion()+ " a "+ region.getPopulationRegion()+" habitants");
                }
                else{
                    System.out.println("La région n'existe pas");
                }

                break;

            case 3:
                break;

            default:
                System.out.println("Votre choix n'est pas bon.");

        }
    }

}
