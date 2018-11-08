package model.Arc;

import model.Noeuds.Aliment;
import model.Noeuds.Noeud;
import model.Noeuds.Person;

public class Cuisine extends Arc {
    public Cuisine(String nom, Double metrique, Noeud source, Noeud dest) {
        super(nom, metrique, source, dest);

        if(!(source instanceof Person) || !(dest instanceof Aliment)){
            throw new IllegalArgumentException("Type de source incorrect");
        }
    }
}
