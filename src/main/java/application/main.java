package application;

import model.Graphe;
import model.Noeud;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Graphe graphe = new Graphe("G1");

        graphe.ajouterArc("A","B","u1",1.0);
        graphe.ajouterArc("A","C","u2",2.0);
        graphe.ajouterArc("B","C","u3",3.0);
        graphe.ajouterArc("C","D","u4",4.0);
        graphe.ajouterArc("B","D","u5",5.0);
        graphe.ajouterArc("E","D","u6",6.0);
        graphe.ajouterArc("B","E","u7",7.0);


        System.out.println(graphe.toString());

        Noeud depart = graphe.rechercherArc("u1").getSource(); //Source A

        List<Noeud> pLargeur = graphe.parcourirLargeur(depart);
        System.out.println("-- Parcourt largeur --");
        for(Noeud noeud : pLargeur){
            System.out.println(noeud.getNom());
        }

        List<Noeud> pProfondeur = graphe.parcourirProfondeur(depart);
        System.out.println("-- Parcourt profondeur --");
        for(Noeud noeud : pProfondeur){
            System.out.println(noeud.getNom());
        }
    }
}
