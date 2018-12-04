package model.Noeuds;

import model.Arc.*;

import java.util.HashMap;

public abstract class Noeud {
    private String nom;
    private HashMap<String, Arc> listeArcSortants = new HashMap<String, Arc>();
    private HashMap<String,Arc> listeArcEntrants = new HashMap<String, Arc>();
    private boolean marque;
    private int niveau;

    private Double dijkstraPoids;
    private Noeud dijkstraPred;
    private HashMap<String,Triplet> vpcc = new HashMap<String, Triplet>();

    public Noeud(String nom) {
        this.nom = nom;
        this.marque = false;
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

    public HashMap<String, Arc> getListeArcEntrants() {
        return listeArcEntrants;
    }

    public void setListeArcSortants(HashMap<String, Arc> listeArcSortants) {
        this.listeArcSortants = listeArcSortants;
    }

    public void setListeArcEntrants(HashMap<String,Arc> listeArcSortants){
        this.listeArcSortants = listeArcSortants;
    }

    public void ajouterArcSortant(EArc typeArc, String nom, Double metrique, Noeud source, Noeud dest){
        if(rechercherArcSortant(nom) == null && (nom != null && !nom.equals(""))){

            Arc arc = createArc(typeArc, nom, metrique, source, dest);
            listeArcSortants.put(nom, arc);
        }else{
            throw new RuntimeException("Un arc existe déjà avec ce nom !");
        }
    }


    public void ajouterArcEntrant(EArc typeArc,String nom, Double metrique, Noeud source, Noeud dest){
        if(rechercherArcEntrant(nom) == null && (nom != null && !nom.equals(""))){
            Arc arc = createArc(typeArc, nom, metrique, source, dest);
            listeArcEntrants.put(nom, arc);
        }else{
            throw new RuntimeException("Un arc existe déjà avec ce nom !");
        }
    }

    Arc rechercherArcSortant(String arc){
        return listeArcSortants.get(arc);
    }

    public Arc rechercherArcEntrant(String arc){
        return listeArcEntrants.get(arc);
    }

    public void supprimerArc(String arc){
        listeArcSortants.remove(arc);
        listeArcEntrants.remove(arc);
    }

    public void setMarque(boolean marque){
        this.marque = marque;
    }

    public boolean estMarque(){
        return this.marque;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
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

    private Arc createArc(EArc typeArc, String nom, Double metrique, Noeud source, Noeud dest) {
        Arc arc =  null;
        switch (typeArc){
            case LIKE:
                arc = new Like(nom, metrique,source, dest);
                break;
            case AMITIE:
                arc = new Amitie(nom, metrique,source, dest);
                break;
            case ECOUTE:
                arc = new Ecoute(nom, metrique,source, dest);
                break;
            case CUISINE:
                arc = new Cuisine(nom, metrique,source, dest);
                break;
            case REGARDE:
                arc = new Regarde(nom, metrique,source, dest);
                break;
        }
        return arc;
    }

    public Double getDijkstraPoids() {
        return dijkstraPoids;
    }

    public void setDijkstraPoids(Double dijkstraPoids) {
        this.dijkstraPoids = dijkstraPoids;
    }

    public Noeud getDijkstraPred() {
        return dijkstraPred;
    }

    public void setDijkstraPred(Noeud dijkstraPred) {
        this.dijkstraPred = dijkstraPred;
    }

  public HashMap<String, Triplet> getVpcc() {
    return vpcc;
  }

  public void addItemVpcc(Triplet triplet){
      this.vpcc.put(triplet.getNom(),triplet);
  }

  public void setVpcc(HashMap<String, Triplet> vpcc) {
    this.vpcc = vpcc;
  }
}
