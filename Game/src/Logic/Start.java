package Logic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Диман on 12.11.2015.
 */
public class Start {
    public static void main(String[] args) {
        Map enemyMap = new Map(10);
        ArrayList<Ship> enemyShips = new ArrayList<>();
        ShootingToTheShip logic = new ShootingToTheShip(enemyMap,enemyShips);

        //Заполняем карту кораблями
        GroupingShip enemyGroupShipLogic = new GroupingShip(enemyMap, enemyShips);
        enemyGroupShipLogic.groupShip();

        //Выводим карту противника
        //И стреляем
        while (!(logic.checkShipsDeck())){
            enemyMap.printMap();

            logic.doShoot();
        }

        System.out.println("Финал игры:");
        enemyMap.printMap();

        for (int j = 0; j < enemyShips.size(); j++) {
            enemyShips.get(j).printShip();
        }

        //Выводим статистику кораблей противника
        //for (int i = 0; i < enemyShips.size(); i++) {
        //    enemyShips.get(i).printShip();
       // }

    }
}
