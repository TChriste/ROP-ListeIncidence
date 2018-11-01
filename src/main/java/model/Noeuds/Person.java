package model.Noeuds;

public class Person extends Noeud {

    private String ville;
    private String prenom;
    private String situation;

    public Person(String nom, String prenom, String situation, String ville) {
        super(nom);
        this.prenom = prenom;
        this.situation = situation;
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

}
