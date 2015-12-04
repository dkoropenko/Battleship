package Logic;

import java.util.ArrayList;

/**
 * Created by Диман on 26.11.2015.
 */
public class Ship {
    //Количество палуб
    private int size;

    //Количество попаданий
    private int hits;

    //Координаты палуб корабля со статусом.
    ArrayList<Deck> decks;

    public Ship(int size){
        //Указываем размер корабля
        this.size = size;
        //Инициируем палубы корабля
        decks = new ArrayList<>();
        hits = 0;
    }

    public void setSize(int size){
        //Указываем размер корабля
        this.size = size;
    }
    public int getSize(){ return this.size; }

    public void setHits(){
        this.hits++;
    }
    public int getHits() { return this.hits; }

    public void setDeckStatus(int x, int y, int status){
        //Статус 1 - Новая палуба.
        //Инициируем новую палубу и даем ей характеристики.
        if (status == 1){
            decks.add(new Deck(x,y,status));
        }

        //Статус 2 - подбит.
        //Проверяется по карте.
        if (status == 2){
            //Увеличиваем инкремент убитых палуб
            //И меняем ее статус.
            hits++;
            for (int i = 0; i < decks.size(); i++) {
                if (decks.get(i).getX() == x && decks.get(i).getY() == y)
                    decks.get(i).setStatus(status);
            }
        }
    }
    public int getDeckStatus(int x, int y){
        int result = 0;
        //Находим плубу с координатами х и у
        //Возвращаем ее статус.
        for (int i = 0; i <decks.size() ; i++) {
            if (decks.get(i).getX() == x && decks.get(i).getY() == y)
                result = decks.get(i).getStatus();
        }
        return result;
    }

    public int getDeckCoordinateX(int deck){
        return decks.get(deck).getX();
    }
    public int getDeckCoordinateY(int deck){
        return decks.get(deck).getY();
    }

    public void printShip(){
        System.out.println(size +" палубный корабль");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (getDeckStatus(i,j) == 1){
                    System.out.print("X");
                }
                else if (getDeckStatus(i,j) == 2){
                    System.out.print("0");
                }
            }
        }
        System.out.println("");
    }
}
