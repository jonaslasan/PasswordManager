
package hranilec.gesel;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author jonas
 */
public class UpravljalecVnosov implements IUpravljalecVnosov {
    
    private static IUpravljalecVnosov Instance = null;
    
    public static IUpravljalecVnosov getInstance()
    {
        if (Instance == null)
            Instance = new UpravljalecVnosov();
        
        return Instance;
    }
    
    public String imeDatoteke(String imeAplikacije)
    {
        return "./vnosi/" + imeAplikacije;
    }
    
    public void UstvariVnos(String imeAplikacije, String ime, String geslo) throws VnosObstajaIzjema
    {
        String fileName = imeDatoteke(imeAplikacije);
        if(LokalniPodatkovniUpravljalec.obstajaDatoteka(fileName))
        {
            throw new VnosObstajaIzjema();
        }
        
        LokalniPodatkovniUpravljalec.ZapisiDatoteko("./vnosi/" + imeAplikacije, "ime", Kriptografija.kriptiraj(ime));
        LokalniPodatkovniUpravljalec.ZapisiDatoteko("./vnosi/" + imeAplikacije, "geslo", Kriptografija.kriptiraj(geslo));
    }
    
    public void IzbrisiVnos(String imeAplikacije)
    {
        String fileName = imeDatoteke(imeAplikacije);
        
        // Vnos ne obstaja, ne naredi ničesar
        if(!LokalniPodatkovniUpravljalec.obstajaDatoteka(fileName))
            return;
        
        LokalniPodatkovniUpravljalec.izbrisiDatoteko(fileName);
    }
    
    public Vnos getVnos(String imeAplikacije)
    {
        Path fileIme = Paths.get("./vnosi/" + imeAplikacije + "/ime");
        Path fileGeslo = Paths.get("./vnosi/" + imeAplikacije + "/geslo");
        
        String ime = "";
        String geslo = "";
        
        try
        {
            ime = Kriptografija.dekriptiraj(Files.readAllBytes(fileIme));
            geslo = Kriptografija.dekriptiraj(Files.readAllBytes(fileGeslo));   
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        Vnos vnos = new Vnos();
        vnos.imeAplikacije = imeAplikacije;
        vnos.ime = ime;
        vnos.geslo = geslo;
        
        return vnos;
    }
    
    public String[][] vsiVnosi()
    {
        File[] vsiVnosi = LokalniPodatkovniUpravljalec.seznamDatotek("./vnosi");
        if (vsiVnosi == null)
        {
            return new String[][]{};
        }
        
        String[][] data = new String[vsiVnosi.length][3];
        System.out.println("DOLZINA " + data.length);
        int c = 0;
        for (File vnos : vsiVnosi)
        {
            System.out.println(vnos.getName());
            Vnos a = getVnos(vnos.getName());
            data[c][0] = a.imeAplikacije;
            data[c][1] = a.ime;
            data[c][2] = a.geslo;
            
            c++;
        }
        
        return data;
    }
}
