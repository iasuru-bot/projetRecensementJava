package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecherchePopulationVille extends MenuService{

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.println("Vous avez choisi de rechercher la population d'une ville:");
        System.out.println("1-Rechercher par le nom de la ville");
        System.out.println("2-Sortir");

        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix){
            case 1:
                System.out.println("Vous avez choisi de rechercher par le nom de la ville");
                System.out.println("Veuillez saisir le nom de la ville recherchée:");


                Scanner scan = new Scanner(System.in);
                String nomVille = null;
                try {nomVille = scan.nextLine();}
                catch (InputMismatchException e){
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }

                boolean villeExiste=false;
                for (Ville v:recensement.getVilles()) {
                    if(v.getNomCommune().equals(nomVille)){
                        villeExiste = true;
                        System.out.println(v.getNomCommune()+" a "+v.getPopulationTotale()+ " habitants");
                    }
                }
                if (!villeExiste){System.err.println("La ville choisie n'existe pas");}
                break;

            case 2:
                break;

            default:
                System.out.println("Votre choix n'est pas bon.");

        }
    }

}
