package applicationfx;
import java.io.Serializable;


public class CompteSimple extends Compte implements Serializable {
    static final long serialVersionUID =1L;
    private float taux;

    public CompteSimple(float soldeInitial) {
        super (soldeInitial);
    }

    public CompteSimple() {
        super(0);
    }

    @Override
    public String toString() {
        return super.toString ()+ "taux=" + taux + "} \n" ;
    }


}
