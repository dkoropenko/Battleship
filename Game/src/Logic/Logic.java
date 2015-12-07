package Logic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by koropenkods on 07.12.2015.
 */
public class Logic {
    //Переменные карт и кораблей
    protected Map map;
    protected ArrayList<Ship> ships;

    protected int shipID;

    //Количество пападаний
    private int hits;

    public Logic (Map map, ArrayList<Ship> ships){
        this.map = map;
        this.ships = ships;
        hits = 0;
    }

    public int doShoot(){ return 1; }

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
        if (this.hits != 20) result = false;

        return result;
    }
}
