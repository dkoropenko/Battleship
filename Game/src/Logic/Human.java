package Logic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by koropenkods on 07.12.2015.
 */
public class Human extends Logic {

    //Переменная для считывания введенных данных
    Scanner inputData;

    //Введенные координаты
    private int x,y;

    public Human (Map map, ArrayList<Ship> ships){
        super(map,ships);
    }

    //Метод для обрабатывания введеных данных.
    public int doShoot() {
        inputData = new Scanner(System.in);
        System.out.println("Введите Х: ");
        x = inputData.nextInt();
        System.out.println("Введите Y: ");
        y = inputData.nextInt();

        //Проверяем введенные данные на попадание.
        if (checkHit(x, y)) return 1;
        else return 2;
    }
}
