package model;

import java.util.HashMap;
import java.util.Iterator;

public class Graphe {
    private String nom;
    private HashMap<String,Noeud> listeNoeuds = new HashMap<String, Noeud>();

    public Graphe(String nom) {
      this.nom = nom;
    }

    public String getNom() {
      return nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public HashMap<String, Noeud> getListeNoeuds() {
      return listeNoeuds;
    }

    public void setListeNoeuds(HashMap<String, Noeud> listeNoeuds) {
        this.listeNoeuds = listeNoeuds;
    }

    public void ajouterNoeud(String nom){
        if(rechercherNoeud(nom) == null && (nom != null && !nom.equals(""))){
            Noeud noeud = new Noeud(nom);
            listeNoeuds.put(nom,noeud);
        }else{
            throw new RuntimeException("Impossible d'ajouter le noeud, vérifiez si un noeud n'existe pas déjà avec le même nom ou vérifier les paramètres");
        }
    }

    public void supprimerNoeud(String nom){
      Noeud victimN = this.rechercherNoeud(nom);
      if(victimN != null){
        supprimerNoeud(victimN);
      }
    }

    public void supprimerNoeud(Noeud victim){
      Arc tmp_a;

      for (Iterator it = victim.getListeArcEntrants().values().iterator(); it.hasNext();){
        tmp_a = (Arc) it.next();
        tmp_a.getSource().supprimerArc(tmp_a.getNom());
      }

      for (Iterator it = victim.getListeArcSortants().values().iterator(); it.hasNext();){
        tmp_a = (Arc) it.next();
        tmp_a.getDest().supprimerArc(tmp_a.getNom());
      }

      this.listeNoeuds.remove(victim.getNom());
    }

    Noeud rechercherNoeud(String nom){
      return listeNoeuds.get(nom);
    }

    public void ajouterArc(String source, String dest, String nom, Double metrique){
        Noeud sourceNoeud = rechercherNoeud(source);
        Noeud destNoeud = rechercherNoeud(dest);

        if(sourceNoeud == null){
            this.ajouterNoeud(source);
            sourceNoeud = this.rechercherNoeud(source);
        }
        if(destNoeud == null){
            this.ajouterNoeud(dest);
            destNoeud = this.rechercherNoeud(dest);
        }
        sourceNoeud.ajouterArcSortant(nom,metrique,sourceNoeud, destNoeud);
        destNoeud.ajouterArcEntrant(nom,metrique,sourceNoeud, destNoeud);
    }

    public void supprimerArc(String nom){

    }

    public Arc rechercherArc(String nom){
        for(Noeud noeud : listeNoeuds.values()){
            Arc searchResult = noeud.rechercherArcEntrant(nom);
            if(searchResult != null){
                return searchResult;
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Noeud noeud : listeNoeuds.values()){
            sb.append(noeud.toString());
            sb.append("\n");
        }
        return sb.toString();
    };
}
