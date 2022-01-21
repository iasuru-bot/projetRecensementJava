package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Departement;
import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.tools.utilitaires.CadreSortie;
import fr.esaip.b2.recensement.tools.utilitaires.CalculPopulation;
import fr.esaip.b2.recensement.tools.utilitaires.PressEnterToContinue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        CadreSortie.Cadre(" Vous avez choisi de rechercher la population d'un département 1-Rechercher par le code du département 2-Sortir");

        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix){
            case 1:
                CadreSortie.Cadre(" Vous avez choisi de rechercher par le code du département Veuillez saisir le code du département recherché:");
                //Récupere le code du département
                Scanner scan = new Scanner(System.in);
                String codeDep = null;

                try {codeDep = scan.next();}
                catch (InputMismatchException e){
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }
                //calcul la population du département
                Departement departement= CalculPopulation.calculHabitantsDepartement(recensement,codeDep);

                //Ressort le résultat
                if(departement!=null){
                    String rep =(" Le département "+ departement.getCodeDepartement()+" a "+departement.getPopulationDepartement()+ " habitants");
                    CadreSortie.Cadre(rep);
                }
                else {
                    System.err.println("Le département n'existe pas");
                }
                break;

            case 2:

                break;

            default:
                CadreSortie.Cadre(" Votre choix n'est pas bon.");
                break;
        }
        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }
}
