package Logic;

import java.util.ArrayList;

/**
 * Created by Диман on 12.11.2015.
 */
public class Start {
    public static void main(String[] args) {
        Map map = new Map(10);
        ArrayList<Ship> ships = new ArrayList<>();

        //Заполняем карту кораблями
        GroupingShip logic = new GroupingShip(map, ships);
        logic.groupShip();

        map.printMap();
    }
}
