package model;

import java.util.HashMap;

public class Noeud {
    private String nom;
    private HashMap<String,Arc> listeArcSortants = new HashMap<String, Arc>();

    public Noeud(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashMap<String, Arc> getListeArcSortants() {
        return listeArcSortants;
    }

    public void setListeArcSortants(HashMap<String, Arc> listeArcSortants) {
        this.listeArcSortants = listeArcSortants;
    }

    void ajouterArcSortant(String nom, Double metrique, Noeud dest){

        if(rechercherArc(nom) == null && (nom != null && !nom.equals(""))){
            Arc arc = new Arc(nom, metrique, dest);
            listeArcSortants.put(nom, arc);
        }else{
            throw new RuntimeException("Un arc existe déjà avec ce nom !");
        }
    }

    Arc rechercherArc(String arc){
        return listeArcSortants.get(arc);
    }

    void supprimerArc(String arc){
        listeArcSortants.remove(arc);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("W++ (");
        sb.append(this.nom);
        sb.append(") = {");

        if(!listeArcSortants.isEmpty()) {
            for (Arc arc : listeArcSortants.values()) {
                sb.append(arc.toString());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }
}
