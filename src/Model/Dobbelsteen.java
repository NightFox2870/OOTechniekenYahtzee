package Model;
import java.util.Random;

/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 */
public class Dobbelsteen {
    private int waarde;
    private boolean vast;
    private Random rand;

    public Dobbelsteen () {
        rand = new Random();
        waarde = 1;
    }

    public int getWaarde () {
        return waarde;
    }

    public boolean isVast () {
        return vast;
    }

    public void zetVast () {
        vast = true;
    }

    public void nietVast () {
        vast = false;
    }

    public void Werp () {
        waarde = rand.nextInt(6)+1;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }
}
