package model.Arc;

import model.Noeuds.Noeud;

public abstract class Arc {
    private String nom;
    private Double metrique;
    private Noeud dest;
    private Noeud source;


    public Arc(String nom, Double metrique, Noeud source, Noeud dest) {
        this.nom = nom;
        this.metrique = metrique;
        this.dest = dest;
        this.source = source;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getMetrique() {
        return metrique;
    }

    public void setMetrique(Double metrique) {
        this.metrique = metrique;
    }

    public Noeud getDest() {
        return dest;
    }

    public Noeud getSource(){
        return source;
    }

    public void setDest(Noeud dest) {
        this.dest = dest;
    }

    public void setSource(Noeud source){
        this.source = source;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(this.nom);
        sb.append(",");
        sb.append(this.dest.getNom());
        sb.append(", ");
        sb.append(this.metrique);
        sb.append(")");

        return sb.toString();
    }
}
