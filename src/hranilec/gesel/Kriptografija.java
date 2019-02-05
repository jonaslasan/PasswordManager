
package hranilec.gesel;

/**
 *
 * @author jonas
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Kriptografija {
    public static byte[] kljuc = null;
    
    public static void nastaviKljuc(byte[] kljuc)
    {
        Kriptografija.kljuc = kljuc;
    }
    
    private static final String ALGORITHM = "AES";

    /**
     * Encrypts the given plain text
     *
     * @param plainText The plain text to encrypt
     */
        
    private static byte[] kriptiraj(byte[] tekst) throws Exception
    {
        SecretKeySpec skrivniKljuč = new SecretKeySpec(kljuc, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, skrivniKljuč);

        return cipher.doFinal(tekst);
    }

    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to decrypt
     */
    private static byte[] decrypt(byte[] tekst) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(kljuc, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(tekst);
    }
    
    private static String kljuc()
    {
       String kljuc = GlobalniPodatki.kljuc;
            if (GlobalniPodatki.kljuc.length() > 16)
            {
                kljuc = GlobalniPodatki.kljuc.substring(0, 16);
            }
            else if (GlobalniPodatki.kljuc.length() < 16)
            {
                kljuc = GlobalniPodatki.kljuc;
                int dolzina = kljuc.length();
                for (int i = 0; i < 16 -dolzina; i++)
                {
                    kljuc = kljuc + "a";
                }
            }
            
            return kljuc;
    }
    
    public static byte[] kriptiraj(String vnos)
    {
        try
        {
            String text = vnos;
            
            String kljuc = kljuc();
            
            // Create key and cipher
            Key aesKey = new SecretKeySpec(kljuc.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            return encrypted;        
        }
        catch (Exception e)
        {
            return new byte[]{};
        }
    }
    
    public static String dekriptiraj(byte[] vnos)
    {
                try
        {
            String key = kljuc();
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(vnos));
            return decrypted;    
        }
        catch (Exception e)
        {
            return "";
        }
    }
}
