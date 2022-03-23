import java.util.Random;

/**
 * generalja, majd random elhelyez 8 papirt
 */
public class Paper extends Mezo{
    public static final int PAPERS_NEEDED = 8;
    public int papersCollected;
    private int papersPlaced = 0;
    KisFa kisfa;
    private final String RESET = "\033[0m";
    private final String RED_BACKGROUND = "\033[41m";

    public Paper(String icon){
        setIcon(RED_BACKGROUND+icon+RESET);
        papersCollected = 0;
    }

    /**
     * a palyan random elhelyez 8  papirt, figyelve arra, hogy min lehet, es min nem lehet papir
     * valamint figyel arra, hogy koordinata alapjan minden tereptargyon csak 1 papir lehessen
     * @param tabla
     * @param paper
     */
    public void placePaper(Tabla tabla,Paper paper, String id, int min, int max){
        Random random = new Random();
        int x;
        int y;
        boolean found = false;
        while(!found){
            if(papersPlaced==8){
                return;
            }
            x = random.nextInt(15)+1;
            y = random.nextInt(15)+1;
            //System.out.println("x coord " + x +"y coord "+ y);
            if(tabla.getMezoLocation(x,y).equals(id) && y>min && y<max ){
                tabla.setMezoLocation(paper,x,y);
                papersPlaced++;
                found=true;
            }
        }
    }

}








