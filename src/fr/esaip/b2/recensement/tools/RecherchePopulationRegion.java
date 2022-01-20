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
                this.calculHabitantsRegion(recensement,nomRegion,0);

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
                this.calculHabitantsRegion(recensement,"",codeRegion);
                break;

            case 3:
                break;

            default:
                System.out.println("Votre choix n'est pas bon.");

        }
    }

    private void calculHabitantsRegion(Recensement recensement, String nomRegion, int codeRegion){
        boolean regionExiste = false;
        int populationRegion= 0;
        String nomRegionFinal=null;
        int codeRegionFinal=0;
        for (Ville v : recensement.getVilles()) {
            if (v.getNomRegion().equals(nomRegion) || v.getCodeRegion()==codeRegion) {
                regionExiste = true;
                populationRegion += v.getPopulationTotale();
                nomRegionFinal=v.getNomRegion();
                codeRegionFinal=v.getCodeRegion();
            }
        }
        if (regionExiste) {
            System.out.println("La région "+ nomRegionFinal+" " +codeRegionFinal+ " a " + populationRegion + " habitants");
        } else {
            System.out.println("La région n'existe pas");
        }
    }
}
