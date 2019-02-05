package hranilec.gesel;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Jonas Lasan
 */
public class HranilecGesel {
    public static void main(String[] args) {
        UpravljalecOken.Inicializiraj();
        UpravljalecOken.prikazi("prijava");
            
        try
        {
            String vnos = "ime";  
            byte[] kript = Kriptografija.kriptiraj(vnos);
            try (FileOutputStream fos = new FileOutputStream("test")) {
               fos.write(kript);
            }
            
            Path fileLocation = Paths.get("test");
            byte[] data = Files.readAllBytes(fileLocation);
            
            String dekript = Kriptografija.dekriptiraj(data);
            System.out.println(dekript);
            
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}