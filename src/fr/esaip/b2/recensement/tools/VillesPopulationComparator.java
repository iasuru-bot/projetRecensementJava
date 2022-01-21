package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Ville;

import java.util.Comparator;

public class VillesPopulationComparator implements Comparator<Ville> {
    @Override
    public int compare(Ville o1, Ville o2) {
        return (Integer.compare(o1.getPopulationTotale(), o2.getPopulationTotale()))*-1;

    }
}
