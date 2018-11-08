package model.Arc;

import model.Noeuds.Musique;
import model.Noeuds.Noeud;
import model.Noeuds.Person;

public class Ecoute extends Arc {
    public Ecoute(String nom, Double metrique, Noeud source, Noeud dest) {
        super(nom, metrique, source, dest);

        if(!(source instanceof Person) || !(dest instanceof Musique)){
            throw new IllegalArgumentException("Type de source incorrect");
        }
    }


}
