package Logic;

/**
 * Created by koropenkods on 20.11.2015.
 */
public class Deck {
    private int x;
    private int y;
    private int status;

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){return status;}
}
