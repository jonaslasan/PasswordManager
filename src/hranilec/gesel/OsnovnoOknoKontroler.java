package hranilec.gesel;

/**
 *
 * @author jonas
 */
public class OsnovnoOknoKontroler {
    public static void OdjaviSe()
    {
        GlobalniPodatki.kljuc = "";
        UpravljalecOken.skrijVse();
        UpravljalecOken.prikazi("prijava");
    }
}
