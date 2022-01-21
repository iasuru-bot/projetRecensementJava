package fr.esaip.b2.recensement;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.tools.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        //création de l'instance recensement à partir d'un csv
        ImporterRecensement importerRecensement = new ImporterRecensement();
        Recensement recensement = new Recensement();
        try{recensement= importerRecensement.CreationRecensement();}
        catch (IOException e){
            e.printStackTrace();
            System.err.println("Problème rencontré lors de la création du rencensement");
        }



        boolean fin = false;
        do {

            Scanner scanner = new Scanner(System.in);
            CadreSortie.Cadre("Texte blabalblabalbalbalbalabalblabalbalbalablababal");
            int choix = 0;
            try {choix = scanner.nextInt();}
            catch (InputMismatchException e){
                e.printStackTrace();
                System.err.println("Vous n'avez pas saisi une valeur chiffrée");
            }

            switch (choix) {
                case 1:
                    RecherchePopulationVille recherchePopulationVille = new RecherchePopulationVille();
                    recherchePopulationVille.traiter(recensement,scanner);
                    break;
                case 2:
                    RecherchePopulationDepartement recherchePopulationDepartement = new RecherchePopulationDepartement();
                    recherchePopulationDepartement.traiter(recensement,scanner);
                    break;
                case 3:
                    RecherchePopulationRegion recherchePopulationRegion= new RecherchePopulationRegion();
                    recherchePopulationRegion.traiter(recensement,scanner);
                    break;

            case 4:
                System.out.println("allo");
                    Affiche10RegionPlusPeuplees affiche10RegionPlusPeuplees= new Affiche10RegionPlusPeuplees();
                    affiche10RegionPlusPeuplees.traiter(recensement,scanner);
                break;
            /*case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;*/
            case 9:
                fin=true;
                break;
            default:

                break;
            }
        }while (!fin);




        /*switch case d'un choix avec dans chaque case un appel d'une classe
        utilitaire permettant d'afficher le résultat de la recherche.
        Chaque classe utilitaire et hérite de la classe abstraite Menu service
        */
        //case 1 getpopu d'une ville .
        //case 2 getpopu d'un dep.
        //case 3 getpopu d'une region.
        //Case 4 afficher les 10 regions les plus pop. utiliser Collections.sort
        //case 5 afficher les 10 dep les plus pop. utiliser Collections.sort
        //case 6 afficher les 10 villes les plus pop d'un dep. utiliser Collections.sort
        //case 7 afficher les 10 villes les plus pop d'une region. utiliser Collections.sort
        //case 8 afficher les 10 villes les plus pop. utiliser Collections.sort
        //case 9 Sortir / message de sortie ?


    }
}
