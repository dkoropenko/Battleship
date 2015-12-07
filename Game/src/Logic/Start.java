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

        //Заполняем карту кораблями
        GroupingShip robotShips = new GroupingShip(enemyMap, enemyShips);
        GroupingShip humanShips = new GroupingShip(playerMap, playerShips);
        robotShips.groupShip();
        humanShips.groupShip();

        //Логика игры
        Robot robot = new Robot(playerMap,playerShips);
        Human human = new Human(enemyMap,enemyShips);

        //Устанавливаем сложность игры
        robot.setDifficult("easy");

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
                    checkHit = human.doShoot(); break;
                case 2:
                    System.out.println("\nСтреляет противник");
                    checkHit = robot.doShoot(); break;
            }

            //Завершаем игру, если у кого-то закончатся корабли.
            if (robot.checkShipsDeck()) count = false;
            if (human.checkShipsDeck()) count = false;
        }


        //Выводим результат
        System.out.println("Финал игры:");
        enemyMap.printMap();

        for (int j = 0; j < enemyShips.size(); j++) {
            enemyShips.get(j).printShip();
        }
    }
}
