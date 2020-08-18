package applicationfx ;

import java.io.Serializable;

public abstract class Compte implements Serializable {
    static final long serialVersionUID =1L;
    public static int nbComptes;
    protected float decouvert;
    protected Client proprietaire;
    protected float solde;
    private int code;
    Compte(float soldeInitial){
        this.solde=soldeInitial;
        nbComptes++;
        this.code=nbComptes;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void retirer(float m){
        solde=solde-m;
    }

    public void verser(float m){
        solde=solde+m;
    }

    public void setDecouvert(float decouvert) {
        this.decouvert = decouvert;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public float getSolde() {
        return solde;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "MainPack.Compte{" +
                "decouvert=" + decouvert +
                ", solde=" + solde +
                ", code=" + code +
                '}';
    }
    public String getType(){
        String[] words =this.getClass().toString().split("\\.");
        return words[1];
    }

}
