package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecherchePopulationVille extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        CadreSortie.Cadre("Vous avez choisi de rechercher la population d'une ville:\n1-Rechercher par le nom de la ville\n2-Sortir");


        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix){
            case 1:
                CadreSortie.Cadre("Vous avez choisi de rechercher par le nom de la ville\nVeuillez saisir le nom de la ville recherchée:");

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
                        String rep=(v.getNomCommune()+" a "+v.getPopulationTotale()+ " habitants");
                        CadreSortie.Cadre(rep);
                    }
                }
                if (!villeExiste){System.err.println("La ville choisie n'existe pas");}
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
