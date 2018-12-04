package application;

import model.Arc.EArc;
import model.Graphe;
import model.Noeuds.ENoeud.*;
import model.Noeuds.ENoeud;
import model.Noeuds.Noeud;
import model.Noeuds.Triplet;

public class mainDijkstra2 {
    public static void main(String[] args) {
        Graphe graphe = new Graphe("Mon graphe");

        graphe.ajouterNoeud(ENoeud.PERSON,"v1", "V1", "", "" );
        graphe.ajouterNoeud(ENoeud.PERSON,"v2", "V1", "", "" );
        graphe.ajouterNoeud(ENoeud.PERSON,"v3", "V1", "", "" );
        graphe.ajouterNoeud(ENoeud.PERSON,"v4", "V1", "", "" );
        graphe.ajouterNoeud(ENoeud.PERSON,"v5", "V1", "", "" );
        graphe.ajouterNoeud(ENoeud.PERSON,"v6", "V1", "", "" );
        graphe.ajouterNoeud(ENoeud.PERSON,"v7", "V1", "", "" );

        graphe.ajouterArc("v1", "v2",EArc.AMITIE, "a1", 2.0);
        graphe.ajouterArc("v1", "v4",EArc.AMITIE,  "a2", 1.0);
        graphe.ajouterArc("v2", "v4",EArc.AMITIE, "a3", 3.0);
        graphe.ajouterArc("v2", "v5",EArc.AMITIE, "a4", 10.0);
        graphe.ajouterArc("v3", "v1",EArc.AMITIE,  "a5", 4.0);
        graphe.ajouterArc("v3", "v6",EArc.AMITIE, "a6", 5.0);
        graphe.ajouterArc("v4", "v3",EArc.AMITIE, "a7", 2.0);
        graphe.ajouterArc("v4", "v6",EArc.AMITIE, "a8", 8.0);
        graphe.ajouterArc("v4", "v5",EArc.AMITIE, "a9", 2.0);
        graphe.ajouterArc("v4", "v7",EArc.AMITIE, "a10", 4.0);
        graphe.ajouterArc("v5", "v7",EArc.AMITIE, "a11", 6.0);
        graphe.ajouterArc("v7", "v6",EArc.AMITIE, "a12", 1.0);

        Noeud v1 = graphe.rechercherArc("a1").getSource();  //Source V1
        System.out.println(graphe.pccAsString("v1","v7"));

    }

}
