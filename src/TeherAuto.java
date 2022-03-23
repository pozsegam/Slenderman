/**
 * Teheratutot hozza letre
 */
public class TeherAuto extends Mezo {

    public TeherAuto() {
        final String BLACK = "\033[0;30m";   // BLACK
        final String YELLOW_BACKGROUND = "\033[43m";
        final String RESET = "\033[0m";
        setIcon(BLACK + YELLOW_BACKGROUND + " 4 " + RESET);
    }

    /**
     * tablara helyezi a teherauto iconjat
     * @param tabla palya
     * @param tAuto teherauto object
     * @param x x coord
     * @param y y coord
     */
    public void createTeherAuto(Tabla tabla, TeherAuto tAuto, int x, int y){
        for(int i = 1; i<4;i++){
            tabla.setMezoLocation(tAuto,x,y);
            x++;
        }
    }

}
