package fr.esaip.b2.recensement.tools;
import java.io.IOException;
import java.nio.file.*;

public class ImporterFichier {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/recensement_2016.csv");
        /*boolean estLisible = Files.isReadable(path);
        System.out.println("Bon chemin : "+estLisible);*/ // c'est un test pour vérifier que le fichier sois bien lisible
    }

}
