package Logic;

import java.util.ArrayList;

/**
 * Created by koropenkods on 18.11.2015.
 */
public class Map {
    //Разер карты.
    private int size;

    //Количество занятых ячеек
    private int cell;

    //Переменная содержит занятые ячейки поля
    private ArrayList<int[]> coordinates;

    public Map(){
        size = 6;
        cell = 0;
        coordinates = new ArrayList<>();
    }

    public int getCell(){
        return cell;
    }

    public void setLocation(int x, int y){
        coordinates.add(new int[]{x,y});
        cell++;
    }

    public int[] getLocations(int partOfCell){
        return coordinates.get(partOfCell);
    }
}
