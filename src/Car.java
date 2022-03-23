/**
 * autot general a palyara
 *
 */
    public class Car extends Mezo {
        public Car() {
            String BLACK = "\u001b[0;30m";
            String BLUE_BACKGROUND = "\u001b[44m";
            String RESET = "\u001b[0m";
            this.setIcon("\u001b[0;30m\u001b[44m 7 \u001b[0m");
        }

    /**
     * tablara helyezi az auto iconjat
     * @param tabla palya
     * @param car car object
     * @param x x coord
     * @param y y coord
     */

        public void createCar(Tabla tabla, Car car, int x, int y){
            for(int i = 1; i<3;i++){
                tabla.setMezoLocation(car,x,y);
                x++;
            }
        }
    }

