import java.util.Scanner;

/**
 * karakterunk mozgasat kezeli
 * karakterunk eletben maradasaert is felelos
 */
public class Karakter extends Mezo {


    KisFa kisFa = new KisFa();
    NagyFa nagyFa = new NagyFa();

    public Karakter(String icon, int x, int y){
        setIcon(icon);
        setX(x);
        setY(y);
    }

    /**
     * vajon megnyertuk a harcot?
     * @param paper papir
     * @return ha megvan a 8 papir true
     */

    public boolean win(Paper paper){
        return paper.papersCollected == 8;
    }






    /**
     * kideriti meghalt- e a karakterunk
     * @param karakter karakter
     * @param slenderMan slenderman
     * @return ha egyezik slenderman es a playerunk pozicioja, akkor true
     */
    public boolean isDead(Karakter karakter, SlenderMan slenderMan){
        return karakter.getX() == slenderMan.getX() && karakter.getY() == slenderMan.getY();
    }




    /**
     * eldonti merre akar menni a jatekos, majd meghivja a mozgashoz tartozo fuggvenyt
     * @param karakter karakter
     * @param tabla tabla
     */

    public void merre(Karakter karakter, Tabla tabla, Paper paper){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("WASD kozul valassz thank you:)");
        }

        switch (input) {
            case "a":
                karakter.left(tabla, karakter,paper);
                break;
            case "d":
                karakter.right(tabla, karakter,paper);
                break;
            case "w":
                karakter.up(tabla, karakter,paper);
                break;
            case "s":
                karakter.down(tabla, karakter,paper);
                break;
        }
    }





    /**
     * balra mozgas+ papir osszegujtes
     * @param tabla palya
     * @param karakter karakter
     */
    public void left(Tabla tabla, Karakter karakter,Paper paper){
        boolean uresmezo = tabla.getMezoLocation(karakter.getX()-1, karakter.getY()).equals(" . ");
        boolean nagyfa = tabla.getMezoLocation(karakter.getX()-1, karakter.getY()).equals(nagyFa.getIcon());
        boolean kisfa = tabla.getMezoLocation(karakter.getX()-1, karakter.getY()).equals(kisFa.getIcon());
        if(getX()==1)return;
        if(tabla.getMezoLocation(karakter.getX()-1, karakter.getY()).equals(paper.getIcon())){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX()-1, getY());
            return;
        }
        if(tabla.getMezoLocation(karakter.getX()-2, karakter.getY()).equals(paper.getIcon())){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX()-2,getY());
            return;
        }
        if(uresmezo  || kisfa || nagyfa){
            karakter.setX(getX()-1);
            tabla.setMezoLocation(karakter, karakter.getX(), karakter.getY());
            tabla.clearPosition(getX()+1,getY());
        }

    }




    /**
     * jobbra mozgas + papir osszegujtes
     * @param tabla palya
     * @param karakter karakter
     */

    public void right(Tabla tabla, Karakter karakter, Paper paper){
        boolean uresmezo = tabla.getMezoLocation(karakter.getX()+1 ,karakter.getY()).equals(" . ");
        boolean nagyfa = tabla.getMezoLocation(karakter.getX()+1, karakter.getY()).equals(nagyFa.getIcon());
        boolean kisfa = tabla.getMezoLocation(karakter.getX()+1, karakter.getY()).equals(kisFa.getIcon());
        if(getX()==15)return;
        if(getY()==0)return;
        if(tabla.getMezoLocation(karakter.getX()+1, karakter.getY()).equals(paper.getIcon())){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX()+1, getY());
            return;
        }
        if(tabla.getMezoLocation(karakter.getX()+2, karakter.getY()).equals(paper.getIcon())){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX()+2,getY());
            return;
        }
        if(uresmezo || kisfa || nagyfa){
            karakter.setX(getX()+1);
            tabla.setMezoLocation(karakter, karakter.getX(), karakter.getY());
            tabla.clearPosition(getX()-1,getY());
        }
    }





    /**
     * felfele mozgas+ papir osszegujtes
     * @param tabla palya
     * @param karakter karakter
     */
    public void up(Tabla tabla, Karakter karakter, Paper paper){
        boolean uresmezo = tabla.getMezoLocation(karakter.getX(), karakter.getY()-1).equals(" . ");
        boolean nagyfa = tabla.getMezoLocation(karakter.getX(), karakter.getY()-1).equals(nagyFa.getIcon());
        boolean kisfa = tabla.getMezoLocation(karakter.getX(), karakter.getY()-1).equals(kisFa.getIcon());
        if(getY()==1)return;
        if(tabla.getMezoLocation(karakter.getX(), karakter.getY()-1).equals(paper.getIcon())){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX(), getY()-1);
            return;
        }
        if(tabla.getMezoLocation(karakter.getX(), karakter.getY()-2).equals(paper.getIcon())){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX(),getY()-2);
            return;
        }
        if(uresmezo || kisfa || nagyfa){
            karakter.setY(getY() -1);
            tabla.setMezoLocation(karakter, karakter.getX(), karakter.getY());
            tabla.clearPosition(getX(),getY() +1);
        }
    }





    /**
     * lefele mozgas+ papir osszegujtes
     * @param tabla palya
     * @param karakter karakter
     */
    public void down(Tabla tabla, Karakter karakter, Paper paper){
        boolean uresmezo = tabla.getMezoLocation(karakter.getX(), karakter.getY()+1).equals(" . ");
        boolean nagyfa = tabla.getMezoLocation(karakter.getX(), karakter.getY()+1).equals(nagyFa.getIcon());
        boolean kisfa = tabla.getMezoLocation(karakter.getX(), karakter.getY()+1).equals(kisFa.getIcon());
        if(getY()==15) return;
        if(tabla.getMezoLocation(karakter.getX(), karakter.getY()+1).equals(paper.getIcon())  ){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX(),getY()+1);
            return;
        }
        if(tabla.getMezoLocation(karakter.getX(), karakter.getY()+2).equals(paper.getIcon())){
            paper.papersCollected++;
            tabla.clearPaperPositin(getX(),getY()+2);
            return;
        }
        if(uresmezo || kisfa || nagyfa ){
            karakter.setY(getY() +1);
            tabla.setMezoLocation(karakter, karakter.getX(), karakter.getY());
            tabla.clearPosition(getX(),getY() -1);
        }
    }

}
