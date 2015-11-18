package Logic;

import java.util.ArrayList;

/**
 * Created by koropenkods on 18.11.2015.
 */
public class Map {
    //Разер карты.
    private int size;

    //Игровое поле. Содержит координаты и значение ячейки.
    // -1 пустое поле.
    // 0 занято кораблем.
    private int[][] cell;

    public Map(){
        size = 10;
        cell = new int[size][size];
    }

    //Инициализируем игровое поле.
    public void initCell(){
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                cell[i][j] = -1;
            }
        }
    }

    //Устанавливаем координаты корабля.
    public void setShipLocation(ArrayList<int[]> x){
        for (int i = 0; i < x.size(); i++) {
            cell[x.get(i)[0]][x.get(i)[1]] = 0;
        }
    }

    //Проверяем занятость ячейки, а также свободные рядом.
    public boolean checkBusyCell(int x, int y){
        if (cell[x][y] == -1) return true;
        return false;
    }
}
