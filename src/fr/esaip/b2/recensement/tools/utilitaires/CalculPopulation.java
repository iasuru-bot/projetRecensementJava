package fr.esaip.b2.recensement.tools.utilitaires;

import fr.esaip.b2.recensement.entities.Departement;
import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Region;
import fr.esaip.b2.recensement.entities.Ville;

public class CalculPopulation {

    //méthode permettant de calculer la population d'une région à partir de son nom ou de son code
    public static Region calculHabitantsRegion(Recensement recensement, String nomRegion, int codeRegion){
        boolean regionExiste = false;
        int populationRegion= 0;
        String nomRegionFinal=null;
        int codeRegionFinal=0;
        Region region= null;
        for (Ville v : recensement.getVilles()) {
            if (v.getNomRegion().equals(nomRegion) || v.getCodeRegion()==codeRegion) {
                regionExiste = true;
                populationRegion += v.getPopulationTotale();
                nomRegionFinal=v.getNomRegion();
                codeRegionFinal=v.getCodeRegion();
            }
        }

        if (regionExiste) {
            region = new Region(populationRegion,nomRegionFinal,codeRegionFinal);
        }
        return region;
    }

    //méthode permettant de calculer la population d'un département à partir  de son code
    public static Departement calculHabitantsDepartement(Recensement recensement, String codeDep) {
        boolean departementExiste = false;
        int populationDepartement = 0;
        Departement departement = null;
        for (Ville v : recensement.getVilles()) {
            if (v.getCodeDepartement().equals(codeDep)) {
                departementExiste = true;
                populationDepartement += v.getPopulationTotale();
            }
        }
        if (departementExiste) {
            departement = new Departement(populationDepartement, codeDep);
        }
        return departement;

    }
}
