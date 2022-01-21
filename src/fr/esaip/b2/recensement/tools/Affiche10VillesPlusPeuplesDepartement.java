package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;

import java.util.*;

public class Affiche10VillesPlusPeuplesDepartement extends MenuService{
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.println("allo");

        int choix = 0;
        try {choix = scanner.nextInt();}
        catch (InputMismatchException e){
            System.err.println("Vous n'avez pas saisi une valeur chiffrée");
        }
        switch (choix){
            case 1:
                System.out.println("Vous avez choisi d'afficher les villes les plus peuplés avec le code du département");
                System.out.println("Veuillez saisir le code du département souhaité:");

                Scanner scan = new Scanner(System.in);
                String codeDepartement = null;
                try {codeDepartement = scan.nextLine();}
                catch (InputMismatchException e){
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }


                List<Ville> villesDansDepartement= new ArrayList<>();
                boolean departementExiste=false;
                for (Ville v:recensement.getVilles()) {
                    if(v.getCodeDepartement().equals(codeDepartement)){
                        departementExiste = true;
                        villesDansDepartement.add(v);
                    }
                }
                Collections.sort(villesDansDepartement,new VillesPopulationComparator());
                for (int i = 0; i < 10; i++) {
                    System.out.println((i+1)+". "+villesDansDepartement.get(i).getNomCommune()+" a "+villesDansDepartement.get(i).getPopulationTotale()+" habitants");
                }


                if (!departementExiste){System.err.println("Le département choisi n'existe pas");}
                break;

            case 2:
                break;

            default:
                System.out.println("Votre choix n'est pas bon.");

        }
    }
}
