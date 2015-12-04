package Logic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Диман on 12.11.2015.
 */
public class Start {
    public static void main(String[] args) {

        //Создаем 2 карты для игрока и противника
        Map enemyMap = new Map(10);
        Map playerMap = new Map(10);

        //Создаем корабли для игрока и противника
        ArrayList<Ship> enemyShips = new ArrayList<>();
        ArrayList<Ship> playerShips = new ArrayList<>();

        //Логика игры
        ShootingToTheShip shootToEnemy = new ShootingToTheShip(enemyMap,enemyShips);
        ShootingToTheShip shootToPlayer = new ShootingToTheShip(playerMap,playerShips);

        //Заполняем карту кораблями
        GroupingShip enemyGroupShipLogic = new GroupingShip(enemyMap, enemyShips);
        GroupingShip playerGroupShipLogic = new GroupingShip(playerMap, playerShips);

        enemyGroupShipLogic.groupShip();
        playerGroupShipLogic.groupShip();

        //Выводим карту игрока и противника
        //И стреляем
        int checkHit = 1;
        boolean count = true;
        while (count){
            switch (checkHit){
                case 1:
                    System.out.println("Карта противника: ");
                    //enemyMap.printHiddenMap();
                    enemyMap.printMap();

                    System.out.println("\nКарта игрока: ");
                     playerMap.printMap();

                    System.out.println("Ваш ход");
                    checkHit = shootToEnemy.doShoot(); break;
                case 2:
                    System.out.println("\nСтреляет противник");
                    checkHit = shootToPlayer.doAutoShoot(); break;
            }

            if (shootToEnemy.checkShipsDeck()) count = false;
            if (shootToPlayer.checkShipsDeck()) count = false;
        }

        System.out.println("Финал игры:");
        enemyMap.printMap();

        for (int j = 0; j < enemyShips.size(); j++) {
            enemyShips.get(j).printShip();
        }
    }
}
