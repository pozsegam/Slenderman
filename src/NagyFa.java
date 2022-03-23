/**
 * nagy meretu fakat generalja
 */

public class NagyFa extends Mezo{

    public NagyFa(){
        final String GREEN_BACKGROUND = "\033[42m";
        final String BLACK = "\033[0;30m";
        final String RESET = "\033[0m";
        setIcon(BLACK + GREEN_BACKGROUND+" 2 "+RESET);
    }


    /**
     * megadott helyre 2 hosszban printeli a nagy meretu fat
     * @param tabla palya
     * @param nagyFa object
     * @param x koordinata
     * @param y koordinata
     */
    public void createNagyFa(Tabla tabla, NagyFa nagyFa, int x, int y){
        for(int i = 1; i<3;i++){
            tabla.setMezoLocation(nagyFa,x,y);
            x++;
        }
    }

}
