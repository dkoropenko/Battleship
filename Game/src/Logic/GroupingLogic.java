package Logic;

import java.util.ArrayList;

/**
 * Created by ƒиман on 18.11.2015.
 */
public class GroupingLogic {
    ArrayList<Ship> ships;
    Map map;

    public GroupingLogic(){
        ships = new ArrayList<>();
        map = new Map();
    }

    public void initMap(){
        map.setSize(10);
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                map.setCellStatus(i,j,0);
            }
        }
    }

    public void groupingShipsOnTheMap(){

        int orientation;
        int x, y;
        int countOfDeck = 4;

        for (int i = 0; i < 10; i++) {
            ships.add(new Ship());
            ships.get(i).setSize(countOfDeck);

            orientation = (int)(Math.random()*100);

            if (orientation > 50){
                x = (int)(Math.random()*10);
                y = (int)(Math.random()*(11 - ships.get(i).getSize()));

                for (int deck = 0; deck < ships.get(i).getSize(); deck++) {
                    ships.get(i).setDecksCoordinates(x,y,deck);
                    map.setCellStatus(x,y,1);
                    y++;
                }
            }
            else{
                x = (int)(Math.random()*(11 - ships.get(i).getSize()));
                y = (int)(Math.random()*10);

                for (int deck = 0; deck < ships.get(i).getSize(); deck++) {
                    ships.get(i).setDecksCoordinates(x,y,deck);
                    map.setCellStatus(x,y,1);
                    x++;
                }
            }

            if (i > 0 && i < 3) countOfDeck = 3;
            if (i > 2 && i < 6) countOfDeck = 2;
            if (i > 5) countOfDeck = 3;
        }

        map.printMap();
    }
}


/*
    private ArrayList<Ship> ships;
    private Map map;

    public GroupingLogic(){

        //»нициализируем карту.
        map = new Map();
        map.initCell();

        //»нициализируем корабли.
        ships = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            ships.add(j,new Ship());
        }
    }

    public void setShipTypes(){
        int count = 0;
        int y = 4;

        while (count < 10){
            ships.get(count).setType(y);

            count++;
            if (count == 1 || count == 2) y = 3;
            if (count >= 3 && count < 6) y = 2;
            if (count >= 6) y = 1;
        }
    }

    //ћетод проверки €чейки и близлежащих р€дом.
    public boolean checkFreedomCell(int z, int x, int y){

        if (map.checkBusyCell(x,y)){
            ships.get(z).setDeckLocation(x, y);
            map.setShipLocation(x,y);
            return false;
        }
        return true;
    }


    //¬ыбираем случайное число дл€ первой палубы
    //четырехпалубного корабл€
    public void GroupLogic(){

        //choose - выбор вертикального или горизонтального положени€.
        //0 - по горизонтали
        //1 - по вертикали
        int choose;

        // оординаты дл€ первой палубы.
        int x,y;
        boolean finish;

        for (int z = 0; z < 10; z++) {
            choose = 1 + (int)(Math.random()*100);
            finish = true;

            while (finish){
                if (choose > 50){
                    //—лучайные координаты дл€ первой палубы.
                    //10 - ships.get(z).getType() -  онтроль выхода за границы
                    x = (int)(Math.random()* (10));
                    y = (int)(Math.random()* (10 - ships.get(z).getType()));

                    for (int i = y; i < ships.get(z).getType()+y; i++) {
                        //¬ зависимости от горизонтального или вертикального
                        //–асположени€ фиксируем одну ось и продвигаемс€ по другой.
                        finish = this.checkFreedomCell(z,x,i);
                    }
                }
                else {
                    x = (int)(Math.random()* (10 - ships.get(z).getType()));
                    y = (int)(Math.random()* (10));

                    for (int i = x; i < ships.get(z).getType()+x; i++) {
                        finish = this.checkFreedomCell(z,i,y);
                    }
                }
            }
        }

        for (int i = 0; i < ships.get(0).getType() ; i++) {
            System.out.println("X:" + ships.get(0).getLocation(i)[0] + " Y:" + ships.get(0).getLocation(i)[1]);
        }

        map.printMap();
    }
 */