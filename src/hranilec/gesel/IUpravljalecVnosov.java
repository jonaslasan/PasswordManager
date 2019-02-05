package hranilec.gesel;

/**
 *
 * @author jonas
 */
public interface IUpravljalecVnosov {
    public void UstvariVnos(String imeAplikacije, String ime, String geslo) throws VnosObstajaIzjema;
    public void IzbrisiVnos(String imeAplikacije);
    public String[][] vsiVnosi();
    public Vnos getVnos(String imeAplikacije);
}
