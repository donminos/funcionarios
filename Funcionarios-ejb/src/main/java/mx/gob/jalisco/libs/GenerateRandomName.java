package mx.gob.jalisco.libs;

import java.util.Random;

/**
 *
 * @author Carlos Cesar Rosas
 */
public class GenerateRandomName {

    public GenerateRandomName() {
    }

    public String Generate() {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < 41) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }
}
