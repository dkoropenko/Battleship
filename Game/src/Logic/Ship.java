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

    //Количество попаданий.
    private int hit;

    public Ship(){
        deck = new ArrayList<>();
        type = 0;
        hit = 0;
    }

    public void setType(int a){
        type = a;
    }
    public int getType(){
        return type;
    }

    //Установка значений координат палубы корабля.
    public void setLocation(String orientation){

        int x = (int) (Math.random()*6);

        if (type == 2 && x > 5)
            x = 6 - x;
        if (type == 3 && x > 4)
            x = 6 - x;
        if (type == 4 && x > 3)
            x = 6 - x;

        if (orientation.equals("vertical"))
        {
            for (int i = 0; i < type; i++) {
                deck.add(new int[]{x, x + i, 1});
            }
        }
        else{
            for (int i = 0; i < type; i++) {
                deck.add(new int[]{x+i, x, 1});
            }
        }

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
                    this.hit++;
                    deck.set(i,new int[]{deck.get(i)[0],deck.get(i)[1],0});
                    return "Попал";
                }
            }
        }
        return "Мимо";
    }

    public void clearOprions(){
        deck.clear();
        hit = 0;
    }
}