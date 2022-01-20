package fr.esaip.b2.recensement.entities;

import java.util.ArrayList;
import java.util.List;

//Classe regroupant juste une liste de villes de toutes les villes.

public class Recensement {

    private List<Ville> villes = new ArrayList<>();

    public List<Ville> getVilles(){
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }
}
