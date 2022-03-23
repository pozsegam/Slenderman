/**
 * hordokat helyezi el
 */
public class Hordo extends Mezo{

    public Hordo(){
        final String BLACK = "\033[0;30m";
        final String PURPLE_BACKGROUND =    "\033[45m";
        final String RESET = "\033[0m";
        setIcon(BLACK + PURPLE_BACKGROUND + " 5 "+RESET);
    }

    /**
     * parameterben kapott hosszban helyezi el a hordo icont
     * @param tabla palya
     * @param hordo object
     * @param x koordinata
     * @param y koordinata
     */
    public void createHordo(Tabla tabla, Hordo hordo, int x, int y){
        for(int i = 1; i<5;i++){
            tabla.setMezoLocation(hordo,x,y);
            x++;
        }
    }


}


