package fr.esaip.b2.recensement.entities;

public class Ville {
    private int codeRegion;
    private int nomRegion;
    private int codeDepartement;
    private int codeCommune;
    private int nomCommune;
    private int populationTotale;






    public Ville(int codeRegion, int nomRegion, int codeDepartement, int codeCommune, int nomCommune, int populationTotale) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartement;
        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
        this.populationTotale = populationTotale;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(int codeRegion) {
        this.codeRegion = codeRegion;
    }

    public int getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(int nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(int codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public int getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(int codeCommune) {
        this.codeCommune = codeCommune;
    }

    public int getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(int nomCommune) {
        this.nomCommune = nomCommune;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    public void setPopulationTotale(int populationTotale) {
        this.populationTotale = populationTotale;
    }
}
