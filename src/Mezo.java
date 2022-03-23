/**
 * minden elem a 2D arrayben
 */
abstract class Mezo {

    private boolean jarhato;
    private String icon;
    private int x,y;

    public String getIcon() {
        return icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isJarhato() {
        return jarhato;
    }

    public void setJarhato(boolean jarhato) {
        this.jarhato = jarhato;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
