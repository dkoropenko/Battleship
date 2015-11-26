package Logic;

/**
 * Created by Диман on 26.11.2015.
 */
public class Ship {
    //Количество палуб
    private int size;

    //Количество попаданий
    private int hits;

    //Координаты палуб корабля со статусом.
    private int[][] deckCoordinates;

    public Ship(int size){
        //Указываем размер корабля
        this.size = size;
        //Инициируем палубы корабля
        deckCoordinates = new int[10][10];
        hits = 0;
    }

    public void setSize(int size){
        //Указываем размер корабля
        this.size = size;
        //Инициируем палубы корабля
        deckCoordinates = new int[size][size];
    }
    public int getSize(){ return this.size; }

    public void setHits(){
        this.hits++;
    }
    public int getHits() { return this.hits; }

    public void setDeckStatus(int x, int y){
        this.deckCoordinates[x][y] = 1;
    }
    public int getDeckStatus(int x, int y){ return this.deckCoordinates[x][y];}
}
