
package hranilec.gesel;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author Jonas Lasan
 */
public class UpravljalecOken {
    static Map<String, JFrame> okna = new HashMap<>();  
    
    public static void Inicializiraj()
    {
        okna.put("prijava", new PrijavaOkno());
        okna.put("osnovno", new OsnovnoOkno());
        okna.put("ustvariVnos", new UstvariVnosOkno());
        okna.put("urediVnos", new UrediVnosOkno());
    }
    
    /**
    * prikazi
    *
    * Prikaže okno s podanim imenom
    *
    * @param ime Ime okna, ki ga želimo prikazati
    * @param centrirajObPrikazu Če je nastavljeno se bo okno prikazalo na sredini ekrana
    */
    public static void prikazi(String ime, boolean centrirajObPrikazu) throws IllegalArgumentException
    {
        // Če ne obstaja okno s podanim imeno
        if (!okna.containsKey(ime))
            throw new IllegalArgumentException();
        
        JFrame okno = okna.get(ime);
        okno.setVisible(true);
        
        if (centrirajObPrikazu)
            okno.setLocationRelativeTo(null);
    }
    
    // Privzeta vrednost centriranja ob prikazu je true
    public static void prikazi(String ime) throws IllegalArgumentException
    {
        prikazi(ime, true);
    }
    
    /**
    * skrij
    *
    * Skrije okno s podanim imenom
    *
    * @param ime Ime okna, ki ga želimo skriti
    */
    public static void skrij(String ime) throws IllegalArgumentException
    {
        // Če ne obstaja okno s podanim imeno
        if (!okna.containsKey(ime))
            throw new IllegalArgumentException();
        
        okna.get(ime).setVisible(false);
    }
    
    /**
    * skrijVse
    *
    * Skrije vsa okno
    */
    public static void skrijVse()
    {
        for(JFrame okno : okna.values())
        {
            okno.setVisible(false);
        }
    }
}
