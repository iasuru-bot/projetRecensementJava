package fr.esaip.b2.recensement.entities;

public class Region {

    private int populationRegion;
    private String nomRegion;
    private int codeRegion;


    public Region() {

    }

    public Region(String nomRegion, int codeRegion) {
        this.nomRegion = nomRegion;
        this.codeRegion = codeRegion;
    }

    public Region(int populationRegion, String nomRegion, int codeRegion) {
        this.populationRegion = populationRegion;
        this.nomRegion = nomRegion;
        this.codeRegion = codeRegion;
    }


    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(int codeRegion) {
        this.codeRegion = codeRegion;
    }

    public int getPopulationRegion() {
        return populationRegion;
    }

    public void setPopulationRegion(int populationRegion) {
        this.populationRegion = populationRegion;
    }

    @Override
    public String toString() {
        return "Region{" +
                "populationRegion=" + populationRegion +
                ", nomRegion='" + nomRegion + '\'' +
                ", codeRegion=" + codeRegion +
                '}';
    }
}
