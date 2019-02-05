package hranilec.gesel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author jonas
 */
public class UpravljalecGesla {
    public static boolean obstajaGeslo()
    {
        return LokalniPodatkovniUpravljalec.obstajaDatoteka("./geslo");
    }
    
    public static boolean ustvariGeslo(String geslo)
    {
        byte[] novoGeslo = Kriptografija.kriptiraj(geslo);
        return LokalniPodatkovniUpravljalec.ZapisiDatoteko(".", "geslo", novoGeslo);
    }
    
    public static boolean preveriGeslo(String geslo)
    {
        Path fileIme = Paths.get("./geslo");

        try
        {
            String shranjenoGeslo = Kriptografija.dekriptiraj(Files.readAllBytes(fileIme));   
            if (geslo.equals(shranjenoGeslo))
                return true;
        }
        catch (Exception e)
        {
        }
        
        return false;
    }
}
