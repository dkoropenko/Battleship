package Logic;

/**
 * Created by koropenkods on 04.12.2015.
 */
public class Deck {
    //Координаты
    private int x,y;

    //Статус палубы
    private int status;

    public Deck(int x, int y, int status){
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public void setCoordinats(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
