package model.Arc;

import model.Noeuds.Film;
import model.Noeuds.Noeud;
import model.Noeuds.Person;

public class Regarde extends Arc {
    public Regarde(String nom, Double metrique, Noeud source, Noeud dest) {
        super(nom, metrique, source, dest);

        if(!(source instanceof Person) || !(dest instanceof Film)){
            throw new IllegalArgumentException("Type de source incorrect");
        }
    }
}
