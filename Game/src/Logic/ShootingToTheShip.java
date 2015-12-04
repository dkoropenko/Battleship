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
    private Scanner inputData;
    //Введенные координаты
    private int x,y, saveX, saveY;

    //Координаты предыдущего выстрела
    //статус предыдущего выстрела
    private int prevX, prevY, prevStatus;
    int shipID;

    //Количество пападаний
    private int hits;

    public ShootingToTheShip(Map map, ArrayList<Ship> ships){
        this.map = map;
        this.ships = ships;
        hits = 0;
        prevStatus = 0;
        x = 0;
        y = 0;
    }

    //Метод для обрабатывания введеных данных.
    public int doShoot(){
        inputData = new Scanner(System.in);
        System.out.println("Введите Х: ");
        x = inputData.nextInt();
        System.out.println("Введите Y: ");
        y = inputData.nextInt();

        //Проверяем введенные данные на попадание.
        if (checkHit(x,y)) return 1;
        else return 2;
    }

    public int doAutoShoot(){

        int check = 0;
        if (prevStatus == 0){
            boolean result = true;
            x = (int)(Math.random() * map.getSize());
            y = (int)(Math.random() * map.getSize());

            while(result){
                //Если ячейка имеет статус "Подбитая палуба" и
                //"Уже попадали в нее", то берем новую случайную
                //Пару координат.
                if (map.getCellStatus(x,y) > 1){
                    x = (int)(Math.random() * map.getSize());
                    y = (int)(Math.random() * map.getSize());
                }
                else{
                    result = false;
                }
            }
        }
        else{
            //Идентифицируем корабль для уточнения
            //Убили мы его или нет
            if (ships.get(shipID).getSize() != ships.get(shipID).getHits()){

                if (prevX > 0 && map.getCellStatus(prevX - 1, prevY) < 2){
                    x = prevX - 1;
                    y = prevY;
                    check++;
                }
                else if (prevX < 9 && map.getCellStatus(prevX + 1, prevY) < 2){
                    x = prevX + 1;
                    y = prevY;
                    check++;
                }
                else if (prevY > 0 && map.getCellStatus(prevX, prevY - 1) < 2){
                    x = prevX;
                    y = prevY - 1;
                    check++;
                }
                else if (prevY < 9 && map.getCellStatus(prevX, prevY + 1) < 2){
                    x = prevX;
                    y = prevY + 1;
                    check++;
                }
            }
            else{
                prevStatus = 0;
            }
        }

        //Проверяем введенные данные на попадание.
        //Если попали, то записываем старые координаты
        //И пытаемся убить корабль
        if (checkHit(x,y)) {
            prevStatus = 1;
            prevX = x;
            prevY = y;

            saveX = x;
            saveY = y;
            return 2;
        }
        else return 1;
    }

    public boolean checkHit(int x, int y){
        boolean result;
        shipID = 0;
        int dx,dy;

        //Если попали, то меняем статус ячейки на карте
        //И статус палубы корабля.
        if (map.getCellStatus(x,y) == 1){
            result = true;
            map.setStatusCell(x,y,2);

            for (int i = 0; i < ships.size(); i++) {

                if (ships.get(i).getDeckStatus(x,y) == 1){
                    ships.get(i).setDeckStatus(x,y,2);
                    hits++;
                    shipID = i;
                }
            }

            //Если палуба последняя, то "убиваем" корабль
            if (ships.get(shipID).getSize() == ships.get(shipID).getHits()){
                //Проверяем каждую палубу корабля
                for (int j = 0; j < ships.get(shipID).getSize(); j++) {
                    //Берем координаты палубы корабля.
                    dx = ships.get(shipID).getDeckCoordinateX(j);
                    dy = ships.get(shipID).getDeckCoordinateY(j);

                    //Меняем статус ячейки на "попадание уже было"
                    if (dx-1 >= 0 && map.getCellStatus(dx-1,dy) != 2) map.setStatusCell(dx-1,dy,3); //Слева
                    if (dx+1 <= 9 && map.getCellStatus(dx+1,dy) != 2) map.setStatusCell(dx+1,dy,3); //Справа
                    if (dy-1 >= 0 && map.getCellStatus(dx,dy-1) != 2) map.setStatusCell(dx,dy-1,3); //Сверху
                    if (dy+1 <= 9 && map.getCellStatus(dx,dy+1) != 2) map.setStatusCell(dx,dy+1,3); //Снизу

                    //По диагоналям
                    if (dx-1 >= 0 && dy-1 >= 0 && map.getCellStatus(dx-1,dy-1) != 2) map.setStatusCell(dx-1,dy-1,3); //Слева сверху
                    if (dx+1 <= 9 && dy-1 >= 0 && map.getCellStatus(dx+1,dy-1) != 2) map.setStatusCell(dx+1,dy-1,3); //Справа сверху
                    if (dx+1 <= 9 && dy+1 <= 9 && map.getCellStatus(dx+1,dy+1) != 2) map.setStatusCell(dx+1,dy+1,3); //Справа снизу
                    if (dx-1 >= 0 && dy+1 <= 9 && map.getCellStatus(dx-1,dy+1) != 2) map.setStatusCell(dx-1,dy+1,3); //Слева снизу
                }
            }
        }
        else{
            map.setStatusCell(x,y,3);
            result = false;
        }
        return result;
    }

    //Метод по проверки оставшихся палуб целых кораблей.
    public boolean checkShipsDeck(){
        boolean result = true;
        if (this.hits == 20) result = false;

        return result;
    }
}