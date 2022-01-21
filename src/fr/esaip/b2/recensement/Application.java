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
            System.out.println("``````````````````$$$$$\n`````````````$$$$$$´´´´$$$$$$\n``````````$$$´´´´´´´´´´´´´´´´$$$\n````````$`$$´´´´´´´´´´´´´´´´´´´´$$\n```````$´$$$´´´´´´´´´´´´´´´´´´´´´$$$$\n`````$´´$$$$´´´´´´´´´´´´´´´´´´´´´´´´´´$\n````$´´$$$$$´´´´´´´´´´$$$$$$$´´´´´´´´´$$\n```$´´´$$$$$$$´´´$$$$$$$$$$$$$$$$$´´´´´$$\n``$´´´´$$$$$$$$$$$$$$$$$$$$$$$$$$$$$´´´´$$\n`$´´´´´´$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$´´$\n`$´´´´´´$$$$$$$$$$$´´´´$$$$$$$$$$$$$$$$$$$\n$´´´´´´´´$$$$$$$$'''''''''$$$$$$$´´´´´´´´$$\n$´´´´´´´´´$$$$$$Recensement$$$$´´´´´´´´´´´$\n`$´´´´´´´´´$$$$$´´´3000´´´$$$´´´´´´´´´´´$\n`$´´´´´´´´´´$$$$$´´´´´´´´$$$$´´´´´´´´´´´$\n`$´´´´´´´´´´´$$$$$$´´´´$$$$$´´´´´´´´´´´$$\n``$´´´´´´´´´´´$$$$$$$$$$$$$$´´´´´´´´´´´$\n``$$´´´´´´´´´´´´$$$$$$$$$$$$´´´´´´´´´´$$\n```$$´´´´´´´´´´´´$$$$$$$$$$´´´´´´´´´´$$\n````$´´´´´´´´´´´´$$$$$$$$$´´´´´´´´´´´$\n`````$´´´´´´´´´´´$$$$$$$$´´´´´´´´´´´$\n``````$$´´´´´´´´´$$$$$$´´´´´´´´´´´$$\n````````$$´´´´´´$$$$$´´´´´´´´´´´$$\n``````````$$$´$$$$´´´´´´´´´´´$$$\n`````````````$$$$$´´´´´´$$$$$\n``````````````````$$$$$$");
            CadreSortie.Cadre("Veuillez choisir une proposition:\n 1-Rechercher la population d'une ville\n 2-Rechercher la population d'un departement\n 3-Rechercher la populationd'une region\n 4-Afficher les 10 régions les plus peuplées\n 5-Afficher les 10 départements les plus peuplés\n 6-Afficher les 10 villes les plus peuplées d'un departement\n 7-Afficher les 10 villes les plus peuplées d'une région\n 8-Afficher les 10 villes les plus peuplées de France\n 9-Sortir");
            int choix = 0;
            try {choix = scanner.nextInt();}
            catch (InputMismatchException e){
                e.printStackTrace();
                System.err.println("Vous n'avez pas saisi une valeur chiffrée");
            }

            switch (choix) {
                case 1 -> {
                    RecherchePopulationVille recherchePopulationVille = new RecherchePopulationVille();
                    recherchePopulationVille.traiter(recensement, scanner);
                }
                case 2 -> {
                    RecherchePopulationDepartement recherchePopulationDepartement = new RecherchePopulationDepartement();
                    recherchePopulationDepartement.traiter(recensement, scanner);
                }
                case 3 -> {
                    RecherchePopulationRegion recherchePopulationRegion = new RecherchePopulationRegion();
                    recherchePopulationRegion.traiter(recensement, scanner);
                }
                case 4 -> {
                    Affiche10RegionPlusPeuplees affiche10RegionPlusPeuplees = new Affiche10RegionPlusPeuplees();
                    affiche10RegionPlusPeuplees.traiter(recensement, scanner);
                }
                case 5 -> {
                    Affiche10DepartementPlusPeuples affiche10DepartementPlusPeuples = new Affiche10DepartementPlusPeuples();
                    affiche10DepartementPlusPeuples.traiter(recensement, scanner);
                }
                case 6 -> {
                    Affiche10VillesPlusPeuplesDepartement affiche10VillesPlusPeuplesDepartement = new Affiche10VillesPlusPeuplesDepartement();
                    affiche10VillesPlusPeuplesDepartement.traiter(recensement, scanner);
                }
                case 7 -> {
                    Affiche10VillesPlusPeuplesRegion affiche10VillesPlusPeuplesRegion = new Affiche10VillesPlusPeuplesRegion();
                    affiche10VillesPlusPeuplesRegion.traiter(recensement, scanner);
                }
                case 8 -> {
                    Affiche10VillesPlusPeuplesFrance affiche10VillesPlusPeuplesFrance = new Affiche10VillesPlusPeuplesFrance();
                    affiche10VillesPlusPeuplesFrance.traiter(recensement, scanner);
                }
                case 9 -> fin = true;
                default -> {
                }
            }
        }while (!fin);




        //case 6 afficher les 10 villes les plus pop d'un dep. utiliser Collections.sort
        //case 7 afficher les 10 villes les plus pop d'une region. utiliser Collections.sort
        //case 8 afficher les 10 villes les plus pop. utiliser Collections.sort
        //case 9 Sortir / message de sortie ?


    }
}
