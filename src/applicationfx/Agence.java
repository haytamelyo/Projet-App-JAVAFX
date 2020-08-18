package applicationfx ;

import java.io.Serializable;
import java.util.Vector;

public class Agence implements Serializable {
    public Client clientCourant;
    public Compte compteCourant;
    public Vector<Client> lesClients;
    public Vector<Compte> lesComptes;
    private int code;
    private String nomAgence;
    static final long serialVersionUID =1L;
    public Agence(int code) {
        this.code = code;
        lesClients=new Vector<> ();
        lesComptes=new Vector<> ();
    }
    public void ajouteClient(Client o){
        lesClients.addElement (o);
        clientCourant=o;
    }

    public void ajouteCompte(Compte cpte){
        lesComptes.addElement (cpte);
        compteCourant=cpte;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public Compte getCompte(int code){
        for(int i=0;i<lesComptes.size ();i++){
            if(lesComptes.elementAt (i).getCode ()==code)
                return lesComptes.elementAt (i);
        }
        System.out.println("Aucun compte existe avec ce code!!");
        return null;
    }
    public Client getClient(int code){
        for(int i=0;i<lesClients.size ();i++){
            if(lesClients.elementAt (i).getMatricule()==code)
                return lesClients.elementAt (i);
        }
        System.out.println("Aucun compte existe avec ce code!!");
        return null;
    }
    public void RemoveClient(Client o){
        this.lesComptes.remove(o.getCompte());
        this.lesClients.remove(o);
    }

    public void RemoveCompte(Compte o){
        this.lesComptes.remove(o);
    }
    public String toString() {
        return "Agence{" +
                "clientCourant=" + clientCourant +
                ", compteCourant=" + compteCourant +
                ", lesClients=" + lesClients +
                ", lesComptes=" + lesComptes +
                ", code=" + code +
                ", nomAgence='" + nomAgence + '\'' +
                '}';
    }
    public Vector<Client> getClientParNom(String s){
        Vector<Client> temp=new Vector<>();
        for(int i=0;i<lesClients.size ();i++){
            if(lesClients.elementAt (i).getNom().toUpperCase().contains(s.toUpperCase())){
                temp.add(lesClients.elementAt (i));
            }
        }
        return temp;
    }
    public Vector<Client> getClientParCIN(String s){
        Vector<Client> temp=new Vector<>();
        for(int i=0;i<lesClients.size ();i++){
            if(lesClients.elementAt (i).getCin().toUpperCase().contains(s.toUpperCase())){
                temp.add(lesClients.elementAt (i));
            }
        }
        return temp;
    }
    public Vector<Client> getClientParCode(String s){
        Vector<Client> temp=new Vector<>();
        for(int i=0;i<lesClients.size ();i++){
            if(lesClients.elementAt (i).getCompte() !=null)
            if(lesClients.elementAt (i).getCompte().getCode() == Integer.parseInt(s)){
                temp.add(lesClients.elementAt (i));
            }
        }
        return temp;
    }
}
