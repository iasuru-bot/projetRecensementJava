package fr.esaip.b2.recensement.tools;

public class ImporterFichier {
    public static void main(String[] args) {
        Path path= Paths.get("TDNot-Java/src/recensement_2016.csv");
        boolean estLisible = Files.isReadable(path);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(estLisible+lines);
    }

}
