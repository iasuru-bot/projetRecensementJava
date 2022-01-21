package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Region;

import java.util.Comparator;

public class RegionPopulationComparator implements Comparator<Region> {
    @Override
    public int compare(Region o1, Region o2) {
        return (Integer.compare(o1.getPopulationRegion(), o2.getPopulationRegion()))*-1;
    }
}

