package fr.esaip.b2.recensement.entities;

import java.util.ArrayList;
import java.util.List;

//Classe regroupant juste une liste de villes de toutes les villes. Attention au constructeur!
// et peut etre méthode pour ajouter une ville à la liste.
public class Recensement {
    private List<Ville> villes = new ArrayList<>();
    public List<Ville> getVilles() { return villes; }
    public void setVilles(List<Ville> villes) {
        this.villes = villes;

        //TO DO: liste de villes
    }
}
