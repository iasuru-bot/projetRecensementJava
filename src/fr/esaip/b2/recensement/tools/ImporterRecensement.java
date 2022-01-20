package fr.esaip.b2.recensement.tools;
import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Ville;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class ImporterRecensement {


   public Recensement CreationRecensement() throws IOException {
        Path path = Paths.get("src/recensement_2016.csv");
        boolean estLisible = Files.isReadable(path);
        // pour vérifier les lignes qui ressortent
        List<String> lignes = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println("Bon chemin : "+estLisible);

        Recensement recensement= new Recensement();

        for (String ligne:lignes) {
            // On commence par découper la ligne en morceaux sur la base du caractère séparateur « ; » .
            // De plus on ne récupère que les morceaux qui nous intéressent.
            // En l’occurrence on ignore les morceaux 3 et 4 dont on a pas besoin dans le TP

            String[] morceaux = ligne.split(";");
            String codeRegion = morceaux[0];
            String nomRegion = morceaux[1];
            String codeDepartement = morceaux[2];
            String codeCommune = morceaux[5];
            String nomCommune = morceaux[6];
            String population = morceaux[7];

            // Pour la population, avant la conversion en int, il faut d’abord supprimer les espaces qui se trouvent à l’intérieur.

            int populationTotale = Integer.parseInt(population.replace(" ", "").trim());

            // On cree maintenant la ville avec toutes ses données utiles

            Ville ville = new Ville(Integer.parseInt(codeRegion),nomRegion,codeDepartement,Integer.parseInt(codeCommune),nomCommune,populationTotale);
            recensement.getVilles().add(ville);
        }
        return recensement;
   }
}
