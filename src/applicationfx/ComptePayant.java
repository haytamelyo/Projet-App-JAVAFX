package applicationfx ;
import java.io.Serializable;

public class ComptePayant extends Compte implements Serializable {
    static final long serialVersionUID =1L;
    private final float tauxOperation=8;
    public ComptePayant(float soldeInitial){
        super(soldeInitial);
    }
    public ComptePayant(){
        super(0);
    }
    public void retirer(float m){
        super.retirer(m+tauxOperation);
    }
    public void verser(float m){
        super.verser(m-tauxOperation);
    }
    public String toString(){
        return(super.toString()+" taux d'opérotion: "+tauxOperation+"\n");
    }
}
