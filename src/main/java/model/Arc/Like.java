package model.Arc;

import model.Noeuds.Conference;
import model.Noeuds.Noeud;
import model.Noeuds.Person;

public class Like extends Arc {
    public Like(String nom, Double metrique, Noeud source, Noeud dest) {
        super(nom, metrique, source, dest);

        if(!(source instanceof Person) || !(dest instanceof Conference)){
            throw new IllegalArgumentException("Type de source incorrect");
        }
    }


}
