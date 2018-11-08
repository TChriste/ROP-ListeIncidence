package model.Arc;

import model.Noeuds.Noeud;
import model.Noeuds.Person;

public class Amitie extends Arc {
    public Amitie(String nom, Double metrique, Noeud source, Noeud dest) {
        super(nom, metrique, source, dest);

        if(!(source instanceof Person) || !(dest instanceof Person)){
            throw new IllegalArgumentException("Type de source incorrect");
        }
    }
}
