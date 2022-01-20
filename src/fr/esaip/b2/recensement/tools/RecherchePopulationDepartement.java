package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService{
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Vous avez choisi de rechercher la population d'un département:");
        System.out.println("1-Rechercher par le code du département");
        System.out.println("2-Sortir");
        boolean departementExiste=false;
        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix){
            case 1:
                System.out.println("Vous avez choisi de rechercher par le code du département");
                System.out.println("Veuillez saisir le code du département recherché:");
                Scanner scan = new Scanner(System.in);
                String codeDep = null;
                int populationDepartement=0;
                try {codeDep = scan.next();}
                catch (InputMismatchException e){
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }
                for (Ville v:recensement.getVilles()) {
                    if(v.getCodeDepartement().equals(codeDep)){
                        departementExiste=true;
                        populationDepartement += v.getPopulationTotale();

                    }
                }
                if(departementExiste){
                    System.out.println("Le département a "+populationDepartement+ " habitants");
                }
                else {
                    System.out.println("Le département n'existe pas");
                }
                break;

            case 2:

                break;

            default:
                System.out.println("Votre choix n'est pas bon.");
                break;

        }
    }
}
