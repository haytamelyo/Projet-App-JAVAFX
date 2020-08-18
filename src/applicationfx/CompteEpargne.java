package applicationfx ;

import java.io.Serializable;


public class CompteEpargne extends Compte implements Serializable {
    static final long serialVersionUID =1L;
    private float taux=6;
    public CompteEpargne(float soldeInitial){
            super(soldeInitial);
    }
    public CompteEpargne(){
        super(0);
    }
    public void calcullnterets(){
            solde=solde*(1+taux/100);
    }
    public float getTaux(){
        return taux;
    }
    public void setTaux(float t){
        taux=t;
    }

    public String toString(){
        return super.toString()+" Taux: "+taux+"\n";
        }
}
