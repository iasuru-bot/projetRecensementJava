package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Recensement;
import fr.esaip.b2.recensement.entities.Region;
import fr.esaip.b2.recensement.entities.Ville;

public class CalculPopulationparRegion {


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
}
