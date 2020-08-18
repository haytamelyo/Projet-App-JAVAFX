package applicationfx ;

import java.io.Serializable;

public class Client implements Serializable {
    public static int nbClients=0;
    private String cin;
    static final long serialVersionUID =1L;
    private Compte compte;
    private int matricule;
    private String nom;

    public Client(String cin, String nom) {
        this.cin = cin;
        this.nom = nom;
        this.compte=null;
        nbClients++;
        this.matricule=nbClients;
    }
    public void affecterCompte(Compte c){
        c.proprietaire=this;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getMatricule() {
        return matricule;
    }

    public Compte getCompte() {
        return compte;
    }
    public void RemoveCompte(){
        this.compte=null;
    }
    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return
                " NOM = '" + nom + '\'' +
                " CIN = '" + cin + '\'';
    }
}
