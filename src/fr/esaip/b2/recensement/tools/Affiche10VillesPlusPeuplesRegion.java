package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;

import java.util.*;

public class Affiche10VillesPlusPeuplesRegion extends MenuService{
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("allo 1 ou 2");

        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix){
            case 1:
                System.out.println("Vous avez choisi d'afficher les villes les plus peuplés avec le nom de la région");
                System.out.println("Veuillez saisir le code du région souhaité:");

                Scanner scan = new Scanner(System.in);
                String nomRegion = null;
                try {nomRegion = scan.nextLine();}
                catch (InputMismatchException e){
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }


                List<Ville> villesDansRegion= new ArrayList<>();
                boolean regionExiste=false;
                for (Ville v:recensement.getVilles()) {
                    if(v.getNomRegion().equals(nomRegion)){
                        regionExiste = true;
                        villesDansRegion.add(v);
                    }
                }
                Collections.sort(villesDansRegion,new VillesPopulationComparator());
                int nombreVillesDansRegion=villesDansRegion.size();
                if (nombreVillesDansRegion>10){nombreVillesDansRegion=10;}
                for (int i = 0; i < nombreVillesDansRegion; i++) {
                    System.out.println((i+1)+". "+villesDansRegion.get(i).getNomCommune()+" a "+villesDansRegion.get(i).getPopulationTotale()+" habitants");
                }


                if (!regionExiste){System.err.println("La region choisie n'existe pas");}
                break;

            case 2:
                break;

            default:
                System.out.println("Votre choix n'est pas bon.");

        }
    }
}
