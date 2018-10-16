package application;

import model.Graphe;

public class main {
    public static void main(String[] args) {
        Graphe graphe = new Graphe("G1");

        graphe.ajouterArc("x3","x1","u4",8.0);
        graphe.ajouterArc("x1","x2","u1",2.0);
        graphe.ajouterArc("x3","x2","u2",20.0);
        graphe.ajouterArc("x2","x2","u3",1.0);

        graphe.supprimerNoeud("x2");


        System.out.println(graphe.toString());
    }
}
