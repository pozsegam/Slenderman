/**
 * a palyat generalja, kezeli
 */
public class Tabla {

    private int ROWS;
    private int COLS;
    private String[][] palya;

    public Tabla(int ROWS, int COLS){
       this.ROWS = ROWS;
       this.COLS = COLS;
       this.palya = new String[this.ROWS][this.COLS];
    }

    /**
     * Letrehozza a 2 dimenzios palya tombot
     */
    public void initBoard(String icon){
        for(int i = 0; i<ROWS;i++){
            for (int j = 0; j<COLS;j++) {
                this.palya[i][j] = icon;
            }
        }
    }

    /**
     * kiprinteli a jelenlegi allapotat a tablanak
     */
    public void printBoard(){
        for(int i = 0; i<ROWS;i++){
            for (int j = 0; j<COLS;j++){
                System.out.print(palya[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * hozzaadja a falakat a palyahoz
     * @param tabla palya
     */

    public void addWall(Tabla tabla) {
        Wall fal = new Wall(" # ");
        fal.addHorizontalWalls(tabla, fal, 0);
        fal.addHorizontalWalls(tabla, fal, 16);
        fal.addVerticalWalls(tabla, fal, 0);
        fal.addVerticalWalls(tabla, fal, 16);
    }


    /**
     * hozzaadja a kis meretu fakat a palyahoz
     * @param tabla palya
     */
    public void addKisFa(Tabla tabla){
        KisFa kisFa1 = new KisFa();
        kisFa1.createKisFa(tabla,kisFa1,3,11);
        kisFa1.createKisFa(tabla,kisFa1,5,13);
        kisFa1.createKisFa(tabla,kisFa1,7,14);
        kisFa1.createKisFa(tabla,kisFa1,11,1);

    }
    /**
     * hozzaadja a nagy meretu fat a palyahoz
     * @param tabla palya
     */
    public void anddNagyFa(Tabla tabla){

        NagyFa nagyFa1 = new NagyFa();
        nagyFa1.createNagyFa(tabla,nagyFa1,1,14);
        nagyFa1.createNagyFa(tabla,nagyFa1,1,15);

        NagyFa nagyFa2 = new NagyFa();
        nagyFa2.createNagyFa(tabla,nagyFa2,14,12);
        nagyFa2.createNagyFa(tabla,nagyFa2,14,13);


    }
    /**
     * hozzaadja a sziklat a palyahoz
     * @param tabla palya
     */
    public void addSzikla(Tabla tabla){

        Szikla szikla1 = new Szikla();
        szikla1.createSzikla(tabla,szikla1,1);
        szikla1.createSzikla(tabla,szikla1,2);
        szikla1.createSzikla(tabla,szikla1,3);

        Szikla szikla2 = new Szikla();
        szikla2.createSzikla(tabla,szikla2,8);
        szikla2.createSzikla(tabla,szikla2,9);
        szikla2.createSzikla(tabla,szikla2,10);

    }


    /**
     * hozzaadja az autot a palyahoz
     * @param tabla palya
     */

    public void addCar(Tabla tabla){
        Car car = new Car();
        car.createCar(tabla,car, 7,8);
        car.createCar(tabla,car, 7,9);
        car.createCar(tabla,car, 7,10);
    }


    /**
     * hozzaadja a teherautot a palyahoz
     * @param tabla palya
     */
    public void addTeherAuto(Tabla tabla){

        TeherAuto tAuto = new TeherAuto();
        tAuto.createTeherAuto(tabla, tAuto,10,11);
        tAuto.createTeherAuto(tabla, tAuto,10,12);
        tAuto.createTeherAuto(tabla, tAuto,10,13);
        tAuto.createTeherAuto(tabla, tAuto,10,14);
        tAuto.createTeherAuto(tabla, tAuto,10,15);

    }

    /**
     * hozzaadja a hordot a palyahoz
     * @param tabla palya
     */
    public void addHordo(Tabla tabla){
        Hordo h1 = new Hordo();
        h1.createHordo(tabla,h1,4,4);
        h1.createHordo(tabla,h1,4,5);

    }

    /**
     * hozzaad 1 hazat a palyahoz
     * @param tabla palya
     */
    public void addHouse(Tabla tabla){
        House house = new House();
        house.createHouseHorizontal(tabla,house,9,3,6);
        house.createHouseHorizontal(tabla,house,11,9,4);
        house.createHouseVertical(tabla,house,9,4,7);
        house.createHouseVertical(tabla,house,14,4,6);
    }

    /**
     * lepeseknel default ures mezore allitja az elozo poziciot
     * @param x x koordinata
     * @param y y koordinata
     */

    public void clearPosition(int x, int y){
            this.palya[y][x] = " . ";
    }


    /**
     * ha osszegyujtottunk 1 papirt, ezzel zoldre allitjuk a mezot
     * @param x x koordinata
     * @param y y koordinata
     */
    public void clearPaperPositin(int x, int y){
        final String GREEN_BACKGROUND = "\033[42m";
        final String RESET = "\033[0m";
        final String BLACK = "\033[0;30m";
        this.palya[y][x] = BLACK+ GREEN_BACKGROUND+ " + "+RESET;
    }

    /**
     * beallitja az adott objektum iconjat, [x][y] helyre
     * @param mezo targy, amit el szeretnenk helyezni
     * @param x x koordinata
     * @param y y koordinata
     */
    public void setMezoLocation(Mezo mezo, int x, int y){
        this.palya[y][x] = mezo.getIcon();
    }

    /**
     * visszaadja az adott objektum iconjat, [x][y] helyrol
     * @param x x koordinata
     * @param y y koordinata
     * @return mi all az adott mezon
     */
    public String getMezoLocation( int x, int y) {
        return this.palya[y][x];
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLS() {
        return COLS;
    }


}
