/**
 * kis mereteu fat general
 */
public class KisFa extends Mezo {

    public KisFa() {
        final String GREEN_BACKGROUND = "\033[42m";
        final String RESET = "\033[0m";
        final String BLACK = "\033[0;30m";
        setIcon(BLACK + GREEN_BACKGROUND + " 1 " + RESET);
    }

    /**
     * megadott hekyre 1 helyre generalja a kis meretu fat
     * @param tabla palya
     * @param kisFa object
     * @param x koordinata
     * @param y koordinata
     */
    public void createKisFa(Tabla tabla, KisFa kisFa, int x, int y) {
        tabla.setMezoLocation(kisFa, x, y);
    }
}
