
public class Start {
    /**
     * amugy 15x15os a palya, a pluszok a falnak vannak
     * beallitja a karakter kezdo poziciojat, plusz az ures mezok ikonjat
     * letrehozza a tablat, beallitja rajta a tereptargyakat, plusz random elhelyez 8db papirt
     *  elindul a game
     *  ha osszegyujtottel 8 papirt, csekkolja es befejezi a futtatast
     *  Vajon eletben van-e kedvenc hosunk?
     *  ha veletlen elvesztettuk, akkor azt jelzi nekunk, es leallitja a gamet
     *  Kiirja mennyi papirt gyujtottunk ossze eddig,
     *  valamint jelzi, mikor fog a szorny kovetkezo alkalommal teleportalni
     *  1nel tobb osszegyujtott papir utan kezd Slenderman mozogni
     */
    public static void main(String[] args){

        final int ROWS = 17;
        final int COLS = 17;
        final int KARAKTER_STARTING_X = 15;
        final int KARAKTER_STARTING_Y = 1;
        final String uresMezo = " . ";
        NagyFa nagyFa = new NagyFa();
        Szikla szikla = new Szikla();
        Hordo hordo = new Hordo();
        Car car = new Car();
        House house = new House();
        TeherAuto tAuto = new TeherAuto();
        Tabla tabla = new Tabla(ROWS,COLS);

        //letrehozza a palyat ures mezokkel
        tabla.initBoard(uresMezo);
        //hozzaadja a tereptargyakat
        addTereptargyak(tabla);
        Paper paper = new Paper(" X ");
        //lerak 8 db papirt minden tereptargyra egyet random, location szerint
        paper.placePaper(tabla, paper, nagyFa.getIcon(),14,16);
        paper.placePaper(tabla, paper, nagyFa.getIcon(),1,14);
        paper.placePaper(tabla,paper, szikla.getIcon(),1,5);
        paper.placePaper(tabla,paper, szikla.getIcon(),5,16);
        paper.placePaper(tabla,paper, hordo.getIcon(),1,16);
        paper.placePaper(tabla,paper, car.getIcon(),1,16);
        paper.placePaper(tabla,paper, house.getIcon(),1,16);
        paper.placePaper(tabla,paper, tAuto.getIcon(),1,16);

        // spawnol a jobb felso sarokba kedvenc karakterunk
        Karakter karakter = new Karakter(" @ ", KARAKTER_STARTING_X,KARAKTER_STARTING_Y);
        tabla.setMezoLocation(karakter, karakter.getX(), karakter.getY());


        //elindul a game
        boolean isRunning = true;
        SlenderMan slenderMan = new SlenderMan();
        while(isRunning){

            //megvan mind a 8 papir? Nyertel!
            if(karakter.win(paper)){
                System.out.println("WOOOOHOOO, NYERTEL!");
                isRunning = false;
                System.exit(0);
            }

            //megegyezik Slendermannal a poziciotok? GAME OVER
            if(karakter.isDead(karakter,slenderMan)){
                System.out.println("GAME OVER, RADSPAWNOLTAK!");
                isRunning = false;
                System.exit(0);
            }

            // karakter movement
            tabla.printBoard();
            karakter.merre(karakter,tabla,paper);

            //Maris osszegyujtottel 1 papirt? Slenderman liked it, le is spawnolt
            if(paper.papersCollected>=1){
                tabla.clearPosition(slenderMan.getX(), slenderMan.getY());
                slenderMan.teleport(tabla,slenderMan, paper,karakter);
            }
            // printeli mi tortenik eppen, hany papirod van
            System.out.println("-----------------------");
            System.out.println("ROUNDCOUNTER: "+slenderMan.getRoundCounter());
            System.out.println("OSSZEGYUJTOTT PAPIR: "+paper.papersCollected);
        }
    }


    /**
     * hozzadja a tereptargyakat, igy a main nem haladja meg az 50 sort xd
     * @param tabla
     */
    public static void addTereptargyak(Tabla tabla){
        tabla.addWall(tabla);
        tabla.addKisFa(tabla);
        tabla.anddNagyFa(tabla);
        tabla.addSzikla(tabla);
        tabla.addCar(tabla);
        tabla.addTeherAuto(tabla);
        tabla.addHordo(tabla);
        tabla.addHouse(tabla);
    }




}
