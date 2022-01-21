package fr.esaip.b2.recensement.tools.comparator;

import fr.esaip.b2.recensement.entities.Region;

import java.util.Comparator;

//Comparateur tri de la population des départements de manière décroissante
public class RegionPopulationComparator implements Comparator<Region> {
    @Override
    public int compare(Region o1, Region o2) {
        return (Integer.compare(o1.getPopulationRegion(), o2.getPopulationRegion()))*-1;
    }
}

