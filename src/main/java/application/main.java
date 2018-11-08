package application;

import model.Arc.Amitie;
import model.Arc.EArc;
import model.Graphe;
import model.Noeuds.*;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Graphe graphe = new Graphe("G1");


        graphe.ajouterNoeud(ENoeud.PERSON,"Ludivine", "Dupont", "Marié", "Neuchâtel");
        graphe.ajouterNoeud(ENoeud.PERSON,"Michel", "Dupond", "Célibataire", "Lausanne");
        graphe.ajouterNoeud(ENoeud.PERSON,"Marie", "Dubois", "Célibataire", "Neuchâtel");

        graphe.ajouterNoeud(ENoeud.MUSIQUE,"Spotify");
        graphe.ajouterNoeud(ENoeud.FILM,"Netflix");
        graphe.ajouterNoeud(ENoeud.CONFERENCE,"Facebook Conference");
        graphe.ajouterNoeud(ENoeud.ALIMENT,"Cookies");

        graphe.ajouterArc("Ludivine", "Marie", EArc.AMITIE, "u1", 1.0);
        graphe.ajouterArc("Ludivine", "Michel", EArc.AMITIE, "u2", 2.0);
        graphe.ajouterArc("Ludivine", "Facebook Conference", EArc.LIKE, "u3", 3.0);
        graphe.ajouterArc("Ludivine", "Cookies", EArc.CUISINE, "u4", 4.0);
        graphe.ajouterArc("Ludivine", "Netflix", EArc.REGARDE, "u5", 5.0);
        graphe.ajouterArc("Ludivine", "Spotify", EArc.ECOUTE, "u6", 6.0);


        graphe.ajouterArc("Marie", "Spotify", EArc.ECOUTE, "u7", 7.0);
        graphe.ajouterArc("Marie", "Michel", EArc.AMITIE, "u8", 8.0);
        graphe.ajouterArc("Marie", "Netflix", EArc.REGARDE, "u9", 9.0);



        System.out.println(graphe.toString());

        Noeud depart = graphe.rechercherArc("u1").getSource(); //Source A

        List<Noeud> pLargeur = graphe.parcourirLargeur(depart,2, Amitie.class);
        System.out.println("-- Parcourt largeur --");
        for(Noeud noeud : pLargeur){
            System.out.println(noeud.getNom());
        }

        List<Noeud> pProfondeur = graphe.parcourirProfondeur(depart);
        System.out.println("-- Parcourt profondeur --");
        for(Noeud noeud : pProfondeur){
            System.out.println(noeud.getNom());
        }

        List<Noeud> amisHabitantNeuchatelEtRegardandNetflix = graphe.getAmisHabitantNeuchatelEtRegardandNetflix(depart);
        System.out.println("-- Amis habitant Neuchâtel et regardant Netflix --");
        for(Noeud noeud : amisHabitantNeuchatelEtRegardandNetflix){
            System.out.println(noeud.getNom());
        }
    }
}
