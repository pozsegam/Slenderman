/**
 * palya koruli falakat generalja
 */
public class Wall extends Mezo {

    public Wall(String icon){
        setIcon(icon);
    }

    /**
     * a palya horizontalis szelet krealja
     * @param tabla palya
     * @param wall object
     * @param sor y koordinata
     */
    public void addHorizontalWalls(Tabla tabla, Wall wall, int sor){
        for(int i = 0; i < tabla.getROWS();i++) {
            tabla.setMezoLocation(wall,i,sor);
        }
    }


    /**
     * palya vertikalis szelet krealja
     * @param tabla palya
     * @param wall object
     * @param oszlop x koordinata
     */
    public void addVerticalWalls(Tabla tabla, Wall wall, int oszlop){
        for(int i = 0; i < tabla.getCOLS();i++) {
            tabla.setMezoLocation(wall,oszlop,i);
        }
    }


}
