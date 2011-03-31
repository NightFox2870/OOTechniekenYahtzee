package Model;

/**
 * Created by: Yarrith Devos, Vladimir Popovic
 * Date: 29-nov-2010
 * Time: 21:14:00
 */

public class Ronde {
    private static int aantalBeurten;
    private static final int MAX_BEURTEN = 3;
    private static Worp worp = new Worp();

    public static void Werp() {
        worp.werp();
        aantalBeurten++;
    }
    
    public static void eersteWorp() {
    	worp.werp();
    }

    public static void zetVast(int dbnr) {
        worp.zetVast(dbnr);
    }

    public static int getAantalBeurten() {
        return aantalBeurten;
    }

    public static void zetAantalBeurten(int i) {
        aantalBeurten = i;
    }

    public static int getMaxBeurten() {
        return MAX_BEURTEN;
    }

    public static String printDbWaarde() {
        return worp.toString();
    }
}
