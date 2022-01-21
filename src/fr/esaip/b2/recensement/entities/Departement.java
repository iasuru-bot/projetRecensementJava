package fr.esaip.b2.recensement.entities;

public class Departement {
    private int populationDepartement;
    private String codeDepartement;


    public Departement() {
    }

    public Departement(int populationDepartement, String codeDepartement) {
        this.populationDepartement = populationDepartement;
        this.codeDepartement = codeDepartement;
    }

    public int getPopulationDepartement() {
        return populationDepartement;
    }

    public void setPopulationDepartement(int populationDepartement) {
        this.populationDepartement = populationDepartement;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "populationDepartement=" + populationDepartement +
                ", codeDepartement='" + codeDepartement + '\'' +
                '}';
    }
}
