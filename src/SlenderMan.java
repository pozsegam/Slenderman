import java.util.Random;

/**
 *Slendermant hozza letre, majd kezeli annak teleportalasat
 */
public class SlenderMan extends Mezo{
    private final String RED = "\033[0;31m";
    private final String RESET = "\033[0m";
    private final String icon = " o ";
    Random random = new Random();
    private int repetitionCounter;
    private int roundCounter;

    public SlenderMan(){
        setIcon(icon);
    }

    /**
     * Slenderman teleportalasat megvalosito fuggveny, kulonbozo esetekre
     *
     * @param tabla palya
     * @param slenderman szorny
     *
     */
    public void teleport(Tabla tabla, SlenderMan slenderman, Paper paper, Karakter karakter){
        roundCounter++;
        //minden otodik lepesben lesz meghivva
        //random locationre teleportal, ha az nem foglalt
        if(getRoundCounter()%5==0){
            boolean found = false;
            while(!found){
                createXY();
                if(validMove(tabla,slenderman,karakter)){
                    System.out.println("Slenderman ennyire van toled "+ getTavolsag(karakter,slenderman));
                    tabla.setMezoLocation(slenderman,getX(),getY());
                    found = true;
                }
            }
            //kevesebb mint 2 papirnal
            //min 5 tavolsagra teleportal toled
        }else if(paper.papersCollected<2 ){
            boolean found = false;
            while(!found){
                createXY();
                if(validMove(tabla,slenderman,karakter) && getTavolsag(karakter,slenderman)>5 ){
                    System.out.println("Slenderman ennyire van toled "+ getTavolsag(karakter,slenderman));
                    tabla.setMezoLocation(slenderman, getX(), getY());
                    found = true;
                }
            }
            //2 - 4 megszerzett papirnal
            //max 5 tavolsagra teleportal toled
            //ha harom egymast koveto lepesben a tavolsag 1, akkor 33% esellyel kap el
        }else if(paper.papersCollected>=2 && paper.papersCollected<4){
            boolean found = false;
            while(!found){
                createXY();
                if(validMove(tabla,slenderman,karakter) && getTavolsag(karakter,slenderman)<6 ){
                    System.out.println("Slenderman ennyire van toled "+ getTavolsag(karakter,slenderman));
                    checkIfRepeated(karakter,slenderman,33);
                    tabla.setMezoLocation(slenderman,getX(),getY());
                    found = true;
                }
            }
            //4 - 6 megszerzett papirnal
            //max 4 tavolsagra teleportal toled
            //ha harom egymast koveto lepesben a tavolsag 1, akkor 50% esellyel kap el
        }else if(paper.papersCollected>=4 && paper.papersCollected<6){
            boolean found = false;
            while(!found){
                createXY();
                if(validMove(tabla,slenderman,karakter) && getTavolsag(karakter,slenderman)<5 ){
                    System.out.println("Slenderman ennyire van toled "+ getTavolsag(karakter,slenderman));
                    checkIfRepeated(karakter,slenderman, 50);
                    tabla.setMezoLocation(slenderman,getX(),getY());
                    found = true;
                }
            }
            //min 6 megszerzett papirnal
            //max 3 tavolsagra teleportal toled
            //ha harom egymast koveto lepesben a tavolsag 1, akkor 66% esellyel kap el
        }else if(paper.papersCollected>=6){
            boolean found = false;
            while(!found){
                createXY();
                if(validMove(tabla,slenderman,karakter) && getTavolsag(karakter,slenderman)<4 ){
                    System.out.println("Slenderman ennyire van toled "+ getTavolsag(karakter,slenderman));
                    checkIfRepeated(karakter,slenderman, 66);
                    tabla.setMezoLocation(slenderman,getX(),getY());
                    found = true;
                }
            }
        }

    }


    /**ha haromszor 1 a tavolsag a szorny es jatekos kozott, akkor szazalekolja az eselyeidet,
     * majd ha nem vagy szerencses vegrehajtja azt
     *
     * @param karakter jatekosunk pozicioja miatt kell
     * @param slenderMan slenderman pozicioja
     * @param szazalek hany szazalek eselyed van elvesziteni a gamet
     */
    public void checkIfRepeated(Karakter karakter, SlenderMan slenderMan, int szazalek){
        boolean tavolsag = getTavolsag(karakter,slenderMan) == 1;
        if(!tavolsag){
            repetitionCounter = 0;
            return;
        }
        repetitionCounter++;
        System.out.println("Ennyiszer volt melletted: " + repetitionCounter);

        if(repetitionCounter == 3){
            System.out.println("NA VAJON TULELED?");
            repetitionCounter=0;
            if(chance(szazalek)){
                System.out.println("GAME OVER, PEDIG UGYES VOLTAL :(");
                System.exit(0);
            }
            System.out.println("YAY U MADE IT! FOLYTATHATOD A GAMET");
        }
    }


    /**
     * konkretan lotto, parameter alapjan eldonti hany szazalekkal nyerhetsz
     * pl.: general egy random szamot 1-100 kozott, ami 25 lett, a parameterunk 33
     * 25<33 tehat return true;
     * @param szazalek hany szazalek eselyed van elvesziteni a gamet
     * @return ha benne van az intervallumban, akkor true, egyebkent false
     */
    private boolean chance(int szazalek){
        boolean kill = random.nextInt(101)+1 <=szazalek;
        return kill;
    }


    /**
     * random location a tablan
     */
    private void createXY(){
        setX(random.nextInt(15)+1);
        setY(random.nextInt(15)+1);
    }

    /**
     * csak uresmezore teleportalhat draga baratunk
     * @param tabla palya
     * @param slenderman slenderman
     * @param karakter karakter
     * @return igaz, ha a palyan nem utkozik akadalyba, es oda tud teleportalni
     */
    private boolean validMove(Tabla tabla, SlenderMan slenderman, Karakter karakter){
       boolean uresmezo = tabla.getMezoLocation(slenderman.getX(), slenderman.getY()).equals(" . ");
       boolean jatekos = tabla.getMezoLocation(slenderman.getX(), slenderman.getY()).equals(" @ ");
        return uresmezo || jatekos;
    }

    /**z
     * Manhattan tavolsagot adja nekunk vissza
     * @param karakter karakter
     * @param slenderman slenderman
     * @return Manhattan tavolsagot adja vissza
     */
    private int getTavolsag( Karakter karakter, SlenderMan slenderman){
       return Math.abs(    (slenderman.getX()- karakter.getX()))  + (Math.abs(slenderman.getY()- karakter.getY()));
    }


    public int getRoundCounter() {
        return roundCounter;
    }

    @Override
    public String getIcon() {
        return RED + icon +RESET;
    }
}
