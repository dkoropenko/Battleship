package Logic;

import java.util.ArrayList;

/**
 * Created by Диман on 12.11.2015.
 */
public class Ship {
    //ID корабля
    private int id;

    //Размер корабля (1-4)
    private int size;

    //Статус корабля
    private int status;

    //Палубы корабля
    private ArrayList<Deck> decks;

    public Ship(){
        id = 0;
        size = 0;
        status = 0;
        decks = new ArrayList<>();
    }

    //Установка значения ID для корабля.
    public void setId(int id){this.id = id;}
    public int getId(){return id;}

    //Установка значения размера корабля.
    //Создание палуб.
    public void setSize(int size){
        this.size = size;

        for (int i = 0; i < size; i++) {
            decks.add(i,new Deck());
            setDeckStatus(i,1);
        }
    }
    public int getSize(){return size;}

    //Задание статуса "жизни" корабля
    public void setStatus(int status){ this.status = status;}
    public int getStatus(){return status;}

    //Задание координат корабля.
    public void setDecksCoordinates (int x, int y, int deck){
        decks.get(deck).setCoordinates(x,y);
    }
    public int getDecksXCoordinate (int deck){
        return decks.get(deck).getX();
    }
    public int getDecksYCoordinate (int deck){
        return decks.get(deck).getY();
    }

    //Задание статуса "жизни" палубы.
    public void setDeckStatus(int deck, int status){
        decks.get(deck).setStatus(status);
    }
    public int getDeckStatus(int deck){
        return decks.get(deck).getStatus();
    }
}



/*
   //Переменная содержит id палубы и адреса палуб
    private ArrayList<int[]> deck;

    //Тип корабля.
    private int type;

    public Ship(){
        deck = new ArrayList<>();
        type = 0;

    }

    public void setType(int a){
        type = a;
    }
    public int getType(){
        return type;
    }

    //Установка значений координат палубы корабля.
    public void setDeckLocation(int x, int y){
        deck.add(new int[]{x, y, 1});
    }
    //Возвращаем координаты определенной палубы.
    public int[] getLocation(int deckNumber){
        return deck.get(deckNumber);
    }

    //Проверка на попадание.
    public String checkHits(int[] hit){

        for (int i = 0; i < type; i++) {
            if (deck.get(i)[2] == 1){
                if (deck.get(i)[0] == hit[0] && deck.get(i)[1] == hit[1] ){
                    deck.set(i,new int[]{deck.get(i)[0],deck.get(i)[1],0});
                    return "Попал";
                }
            }
        }
        return "Мимо";
    }

    public void clearOprions(){
        deck.clear();
    }
 */