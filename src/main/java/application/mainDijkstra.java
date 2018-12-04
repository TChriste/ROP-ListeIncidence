package application;

import static sun.security.x509.CertificateVersion.V1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import model.Arc.EArc;
import model.Graphe;
import model.Noeuds.ENoeud;
import model.Noeuds.Noeud;
import model.Noeuds.Triplet;

public class mainDijkstra {


  public static void main(String[] args) {
    Graphe graphe = new Graphe("G1");


    graphe.ajouterNoeud(ENoeud.PERSON,"V1", "V1", "", "");
    graphe.ajouterNoeud(ENoeud.PERSON,"V2", "V2", "", "");
    graphe.ajouterNoeud(ENoeud.PERSON,"V3", "V3", "", "");
    graphe.ajouterNoeud(ENoeud.PERSON,"V4", "V4", "", "");

    graphe.ajouterArc("V1", "V2", EArc.AMITIE, "u1", 2.0);
    graphe.ajouterArc("V1", "V4", EArc.AMITIE, "u2", 10.0);
    graphe.ajouterArc("V2", "V3", EArc.AMITIE, "u3", 10.0);
    graphe.ajouterArc("V2", "V4", EArc.AMITIE, "u4", 3.0);
    graphe.ajouterArc("V4", "V3", EArc.AMITIE, "u5", 6.0);

    System.out.println(graphe.toString());

    Noeud depart = graphe.rechercherArc("u1").getSource();  //Source V1
    graphe.dijkstra(depart);

    System.out.println("--- Résultat ---");

    HashMap vpccNonOrdree = graphe.rechercherArc("u1").getSource().getVpcc();
    System.out.println(vpccNonOrdree.get("V1"));
    System.out.println(vpccNonOrdree.get("V2"));
    System.out.println(vpccNonOrdree.get("V3"));
    System.out.println(vpccNonOrdree.get("V4"));

  }
}
