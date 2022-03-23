/**
 * szikla krealasaert felelos
 */

public class Szikla extends Mezo{
    public Szikla(){
        final String BLACK_BACKGROUND = "\033[40m";
        final String RESET = "\033[0m";
        setIcon(BLACK_BACKGROUND+" 3 "+RESET);
    }

    /**
     * megadott helyre 3 hosszban elhelyezi a szikla object iconjat
     * @param tabla palya
     * @param szikla object
     * @param sor y koordinata
     */
    public void createSzikla(Tabla tabla, Szikla szikla, int sor){
        for(int i = 1; i<4;i++){
            tabla.setMezoLocation(szikla,i,sor);
        }
    }
}
