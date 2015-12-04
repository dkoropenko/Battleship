package Logic;

/**
 * Created by koropenkods on 24.11.2015.
 */
public class Map {
    //Размер карты
    private int size;

    //Индексы массива координаты ячеки
    //Значение - состояние ячеки
    //0 - пустая ячейка
    //1 - стоит палуба корабля
    //2 - подбитая палуба корабля
    //3 - уже произведено попадание в эту ячейку
    private int[][] coodrinates;

    public Map(int size){
        this.size = size;
        coodrinates = new int[size][size];
    }

    public int getSize(){
        return this.size;
    }

    void initMap(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                coodrinates[i][j] = 0;
            }
        }
    }

    public void setStatusCell(int x, int y, int status){
        coodrinates[x][y] = status;
    }

    public int getCellStatus(int x, int y){
        return coodrinates[x][y];
    }


    public void printMap(){
        System.out.println(" * 0 1 2 3 4 5 6 7 8 9 *");
        System.out.println("** * * * * * * * * * * *");

        for (int i = 0; i < size; i++) {
            System.out.print(i +"* ");
            for (int j = 0; j < size; j++) {
                if(coodrinates[j][i] == 1) System.out.print("X ");
                else if (coodrinates[j][i] == 2) System.out.print("S ");
                else if (coodrinates[j][i] == 3) System.out.print("H ");
                else System.out.print("^ ");
            }
            System.out.println("*");
        }
        System.out.println("** * * * * * * * * * * *");
    }

    public void printHiddenMap(){
        System.out.println(" * 0 1 2 3 4 5 6 7 8 9 *");
        System.out.println("** * * * * * * * * * * *");

        for (int i = 0; i < size; i++) {
            System.out.print(i +"* ");
            for (int j = 0; j < size; j++) {
                if (coodrinates[j][i] == 2) System.out.print("X ");
                else if (coodrinates[j][i] == 3) System.out.print("H ");
                else System.out.print("^ ");
            }
            System.out.println("*");
        }
        System.out.println("** * * * * * * * * * * *");
    }
}
