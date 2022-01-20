package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;

import java.util.Scanner;

public class RecherchePopulationVille extends MenuService{

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.println("Vous avez choisi de rechercher la population d'une ville:");
        System.out.println("1-Rechercher par le nom de la ville");
        System.out.println("2-Rechercher par le code de la ville");
        System.out.println("3-Sortir");
        //boolean villeExiste=false;
        int choix = scanner.nextInt();
        switch (choix){
            case 1:
                System.out.println("Vous avez choisi de rechercher par le nom de la ville");
                System.out.println("Veuillez saisir le nom de la ville recherchée:");
                Scanner scan = new Scanner(System.in);
                String nomVille = scan.nextLine();
                for (Ville v:recensement.getVilles()) {
                    if(v.getNomCommune().contains(nomVille)){
                        //villeExiste = true;
                        System.out.println(v.getNomCommune()+" a "+v.getPopulationTotale()+ " habitants");
                    }
                }
                //if (!villeExiste){System.out.println("Veuillez saisir le nom de la ville recherchée:");
                //}
                break;

            case 2:
                System.out.println("Vous avez choisi de rechercher par le code d'une ville");
                System.out.println("Attention plusieurs villes ont peut être le même code");
                System.out.println("Veuillez saisir le code de la ville recherchée:");
                int codeVille = scanner.nextInt();
                for (Ville v:recensement.getVilles()) {
                    if(v.getCodeCommune()==codeVille){
                        //villeExiste = true;
                        System.out.println(v.getNomCommune()+" a "+v.getPopulationTotale()+ " habitants");
                    }
                }
                break;

            case 3:
                break;

            default:
                System.out.println();

        }




    }
}
