package applicationfx ;

import java.io.*;

public class BaseDonnes {
    public static  void Save(Agence a) throws IOException {
            FileOutputStream f=new FileOutputStream("MonAgence");
            ObjectOutputStream o=new ObjectOutputStream(f);
            o.writeObject(a);
            o.close();
            f.close();
        }
    public static Agence Load() throws IOException, ClassNotFoundException {
            File tempFile = new File("MonAgence");
            boolean exists = tempFile.exists();
            if (exists){
                Agence a;
                FileInputStream f=new FileInputStream("MonAgence");
                ObjectInputStream o=new ObjectInputStream(f);
                a=(Agence)o.readObject();
                Compte.nbComptes=a.lesComptes.size();
                Client.nbClients=a.lesClients.size();
                o.close();
                f.close();
                return a;
            }else{
                BaseDonnes.Save(new Agence(1));
                return BaseDonnes.Load();
            }

    }
}

