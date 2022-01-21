package fr.esaip.b2.recensement.tools;

import fr.esaip.b2.recensement.entities.Departement;

import java.util.Comparator;

public class DepartementPopulationComparator implements Comparator<Departement> {
    @Override
    public int compare(Departement o1, Departement o2) {
        return (Integer.compare(o1.getPopulationDepartement(), o2.getPopulationDepartement()))*-1;
    }
}
