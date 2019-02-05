package hranilec.gesel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author jonas
 */
public class LokalniPodatkovniUpravljalec {

    public static boolean obstajaDatoteka(String imeDatoteke)
    {
        File file = new File(imeDatoteke);
        
        if (file.exists())
            return true;
            
        return false;
    }
    
    public static boolean izbrisiDatoteko(String imeDatoteke)
    {
        File file = new File(imeDatoteke);
        try
        {
            izbrisiMapo(file);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return true;
    }
    
    static boolean izbrisiMapo(File directoryToBeDeleted) {
    File[] allContents = directoryToBeDeleted.listFiles();
    if (allContents != null) {
        for (File file : allContents) {
            izbrisiMapo(file);
        }
    }
    return directoryToBeDeleted.delete();
}
    
    public static ArrayList<String> PreberiDatoteko (String direktorij, String imeDatoteke, int indeksVrstice)
    {
        BufferedReader Buff;
        ArrayList<String> vrstice = new ArrayList<String>();
        try {
            FileReader reader = new FileReader(direktorij + "/" + imeDatoteke);
            
            Buff = new BufferedReader(reader);
            for (int i = 0; i < indeksVrstice; i++)
            {
                vrstice.add(Buff.readLine());
            }
            
            Buff.close();
            reader.close();
        } catch (Exception ex) {
        }
        //
        finally
        {
            // Tako dobimo prazno vrstico tudi v premire, če vrstica ne obstaja
            return vrstice;
        }
    }
    
    public static boolean ZapisiDatoteko (String direktorij, String ime, byte[] vnos)
    {
        File file = new File(direktorij);
        if (!file.exists())
            file.mkdirs();
        
        try (FileOutputStream fos = new FileOutputStream(direktorij + "/" + ime)) {
               fos.write(vnos);
        }
        catch (Exception e)
        {
         return false;   
        }
        
        return true;
    }
    
    public static File[] seznamDatotek (String direktorij)
    {
        File file = new File(direktorij);
        if (!file.exists())
            return null;
        return file.listFiles();
    }
}
