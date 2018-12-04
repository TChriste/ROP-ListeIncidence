package model.Noeuds;

public class Triplet {
  private String nom;
  private Double dijkstraPoids;
  private Noeud dijkstraPred;

  public Triplet(String nom, Double dijkstraPoids, Noeud dijkstraPred) {
    this.nom = nom;
    this.dijkstraPoids = dijkstraPoids;
    this.dijkstraPred = dijkstraPred;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
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

  public String toString(){
    String dijkstraPred = "null";
    if(this.dijkstraPred != null){
      dijkstraPred = this.dijkstraPred.getNom();
    }

    StringBuilder sb = new StringBuilder();
    sb.append("(");
    sb.append(this.nom);
    sb.append(",");
    sb.append(this.dijkstraPoids);
    sb.append(",");
    sb.append(dijkstraPred);
    sb.append(")");

    return sb.toString();
  }
}
