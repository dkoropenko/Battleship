package Logic;

import java.util.ArrayList;

/**
 * Created by Диман on 12.11.2015.
 */
public class Ship {
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
}