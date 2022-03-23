/**
 * hazat general a palyara
 */
public class House extends Mezo{
    public House(){
        final String CYAN_BACKGROUND = "\033[46m";
        final String RESET = "\033[0m";
        final String BLACK = "\033[0;30m";
        setIcon(BLACK + CYAN_BACKGROUND+" 6 "+RESET);
    }





    /**
     * horizontalisan helyezi el parameter alapjan a haz ikonjat
     * @param tabla palya
     * @param house haz objekt
     * @param x koordinata
     * @param y koordinate
     * @param milyenhosszu meddig epitsen
     */

    public void createHouseHorizontal(Tabla tabla, House house, int x, int y,int milyenhosszu){
        for(int i = 1; i<=milyenhosszu;i++){
            tabla.setMezoLocation(house,x,y);
            x++;
        }
    }




    /**
     * vertikalisan el parameter alapjan a haz ikonjat
     * @param tabla palya
     * @param house haz objekt
     * @param x koordinata
     * @param y koordinate
     * @param milyenhosszu meddig epitsen
     */
    public void createHouseVertical(Tabla tabla, House house, int x, int y, int milyenhosszu){
        for(int i = 1; i<milyenhosszu;i++){
            tabla.setMezoLocation(house,x,y);
            y++;
        }
    }


}
