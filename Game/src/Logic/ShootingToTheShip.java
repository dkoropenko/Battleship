package Logic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by koropenkods on 30.11.2015.
 */
public class ShootingToTheShip {
    //Переменные карты и кораблей
    private Map map;
    private ArrayList<Ship> ships;

    //Переменная для считывания введенных данных
    Scanner inputData;
    //Введенные координаты
    int x,y;
    //Количество пападаний
    int hits;

    public ShootingToTheShip(Map map, ArrayList<Ship> ships){
        this.map = map;
        this.ships = ships;
        hits = 0;
    }

    //Метод для обрабатывания введеных данных.
    public int doShoot(){
        inputData = new Scanner(System.in);
        System.out.println("Введите Х: ");
        x = inputData.nextInt();
        System.out.println("Введите Y: ");
        y = inputData.nextInt();

        //Проверяем введенные данные на попадание.
        if (checkHit(x,y))
            return 1;
        else
            return 2;
    }

    public int doAutoShoot(){

        x = (int)(Math.random()*10);
        y = (int)(Math.random()*10);

        //Проверяем введенные данные на попадание.
        if (checkHit(x,y))
            return 1;
        else
            return 2;
    }

    public boolean checkHit(int x, int y){
        boolean result;

        if (map.getCellStatus(x,y) == 1){
            System.out.println("Вы попали в корабль");
            result = true;
            map.setStatusCell(x,y,2);

            for (int i = 0; i < ships.size(); i++) {
                if (ships.get(i).getDeckStatus(x,y) == 1){
                    ships.get(i).setDeckStatus(x,y,2);
                    hits++;
                }
            }
        }
        else{
            System.out.println("Мимо. Попробуйте снова");
            result = false;
        }
        return result;
    }

    //Метод по проверки оставшихся палуб целых кораблей.
    public boolean checkShipsDeck(){
        boolean result = false;
        if (this.hits == 20) result = true;

        return result;
    }
}
