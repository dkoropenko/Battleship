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
    //И зона вокруг ячейки
    //На вход приходят координаты палуб корабля
    public void setShipLocation(int x, int y){
        cell[x][y] = 0;
        if (x > 0 && y > 0 && x < 9 && y < 9){
            if (cell[x-1][y-1] != 0)    cell[x-1][y-1] = 1;
            if (cell[x-1][y] != 0)      cell[x-1][y] = 1;
            if (cell[x-1][y+1] != 0)    cell[x-1][y+1] = 1;
            if (cell[x][y-1] != 0)      cell[x][y-1] = 1;
            if (cell[x][y+1] != 0)      cell[x][y+1] = 1;
            if (cell[x+1][y-1] != 0)    cell[x+1][y-1] = 1;
            if (cell[x+1][y] != 0)      cell[x+1][y] = 1;
            if (cell[x+1][y+1] != 0)    cell[x+1][y+1] = 1;
        }
        else
        if (x == 0 && y == 0){
            if (cell[x][y+1] != 0)      cell[x][y+1] = 1;
            if (cell[x+1][y] != 0)      cell[x+1][y] = 1;
            if (cell[x+1][y-1] != 0)    cell[x+1][y-1] = 1;
        }
        else
        if (x == 10 && y == 0){
            if (cell[x-1][y] != 0)      cell[x-1][y] = 1;
            if (cell[x-1][y+1] != 0)    cell[x-1][y+1] = 1;
            if (cell[x][y+1] != 0)      cell[x][y+1] = 1;
        }
        else
        if (x == 10 && y == 10){
            if (cell[x-1][y-1] != 0)    cell[x-1][y-1] = 1;
            if (cell[x-1][y] != 0)      cell[x-1][y] = 1;
            if (cell[x][y-1] != 0)      cell[x][y-1] = 1;
        }
        else
        if (x == 0 && y == 10){
            if (cell[x][y-1] != 0)      cell[x][y-1] = 1;
            if (cell[x+1][y-1] != 0)    cell[x+1][y-1] = 1;
            if (cell[x+1][y] != 0)      cell[x+1][y] = 1;
        }
        else
        if (y == 0){
            if (cell[x-1][y] != 0)      cell[x-1][y] = 1;
            if (cell[x-1][y+1] != 0)    cell[x-1][y+1] = 1;
            if (cell[x][y+1] != 0)      cell[x][y+1] = 1;
            if (cell[x+1][y] != 0)      cell[x+1][y] = 1;
            if (cell[x+1][y+1] != 0)    cell[x+1][y+1] = 1;
        }
        else
        if (x == 0){
            if (cell[x][y-1] != 0)      cell[x][y-1] = 1;
            if (cell[x][y+1] != 0)      cell[x][y+1] = 1;
            if (cell[x+1][y-1] != 0)    cell[x+1][y-1] = 1;
            if (cell[x+1][y] != 0)      cell[x+1][y] = 1;
            if (cell[x+1][y-1] != 0)    cell[x+1][y-1] = 1;
        }
        else
        if (x == 10){
            if (cell[x][y-1] != 0)      cell[x][y-1] = 1;
            if (cell[x-1][y-1] != 0)    cell[x-1][y-1] = 1;
            if (cell[x-1][y] != 0)      cell[x-1][y] = 1;
            if (cell[x-1][y+1] != 0)    cell[x-1][y+1] = 1;
            if (cell[x][y+1] != 0)      cell[x][y+1] = 1;
        }
        else
        if (y == 10){
            if (cell[x-1][y] != 0)      cell[x-1][y] = 1;
            if (cell[x-1][y-1] != 0)    cell[x-1][y-1] = 1;
            if (cell[x][y-1] != 0)      cell[x][y-1] = 1;
            if (cell[x+1][y-1] != 0)    cell[x+1][y-1] = 1;
            if (cell[x+1][y] != 0)      cell[x+1][y] = 1;
        }
    }

    public void printMap(){
        System.out.println("\n* * * * * * * * * * * * * * * *");
        for (int i = 0; i < 10; i++) {
            System.out.print("*");

            for (int j = 0; j < 10; j++) {
                if (cell[i][j] == 0) System.out.print(" X ");
                else System.out.print(" ^ ");
            }
            System.out.println("*");
        }
        System.out.println("* * * * * * * * * * * * * * * *");
    }

    //Проверяем занятость ячейки, а также свободные рядом.
    public boolean checkBusyCell(int x, int y){
        if (cell[x][y] == -1){
            return true;
        }
        if (cell[x][y] != 1)
            return true;
        return false;
    }
}
