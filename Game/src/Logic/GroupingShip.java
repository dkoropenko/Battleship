package Logic;

/**
 * Created by koropenkods on 24.11.2015.
 */
public class GroupingShip {
    Map map;

    public GroupingShip(Map map){
        this.map = map;
        map.initMap();
    }


    public void groupShip(){
        //Координаты и направление коробля
        int x = 0,y = 0;
        int locate;

        //Ставим 4-х палубный корабль
        //случайным образом.
        int size = 4;
        locate = (int)(Math.random() * 2) + 1;

        switch (locate){
            case 1:
                x =(int)(Math.random() * 9);
                y =(int)(Math.random() * (10-size));
                break;
            case 2:
                x =(int)(Math.random() * (10-size));
                y =(int)(Math.random() * 9);
                break;
        }
        this.createShip(x,y,size,locate);


        boolean iterac = true;
        int count = 0;
        size = 3;

        for (int j = 0; j < 9; j++) {
            while (iterac){
                locate = (int)(Math.random() * 2) + 1;

                switch (locate){
                    case 1:
                        x =(int)(Math.random() * 9);
                        y =(int)(Math.random() * (10-size));
                        count = checkFreedomCellVertical(x,y,size);
                        break;
                    case 2:
                        x =(int)(Math.random() * (10-size));
                        y =(int)(Math.random() * 9);
                        count = checkFreedomCellHorizont(x,y,size);
                        break;
                }


                if (count == 0){
                    for (int i = y; i < y+size; i++) {
                        this.createShip(x,y,size,locate);
                    }
                    iterac = false;
                }
            }

            iterac = true;
            System.out.println("size: "+ size);
            if (j == 0) size = 3;
            if (j == 1 || j == 2 || j == 3) size = 2;
            if (j == 4 || j == 5 || j == 6 || j == 7) size = 1;
        }

        map.printMap();
    }

    private void createShip(int x, int y, int size, int locate){
        switch (locate){
            case 1:
                for (int i = y; i < y+size; i++) {
                    map.setStatusCell(x,i,1);
                }
                break;
            case 2:
                for (int i = x; i < x+size; i++) {
                    map.setStatusCell(i,y,1);
                }
                break;
        }
    }

    private int checkFreedomCellVertical(int x, int y, int size){
        int count = 0;

        for (int i = y; i < y+size ; i++) {
            //Проверяем место куда ставим палубу
            if (map.getCellStatus(x,i) == 1) {
                count++;
                //System.out.println("1 if");
                break;
            }

            //Промеряем место слева от корабля
            if (x > 0 && map.getCellStatus(x - 1, i) == 1) {
                count++;
                //System.out.println("2 if");
                break;
            }

            //Проверяем место справа от корабля
            if (x < 9 && map.getCellStatus(x + 1, i) == 1) {
                count++;
                //System.out.println("3 if");
                break;
            }
        }

        for (int i = 0; i < 3; i++) {
            //Проверяем сверху корабля
            if (x-1+i > 0 && x-1+i < 9 && y > 0 && map.getCellStatus(x-1+i, y - 1) == 1) {
                count++;
                //System.out.println("4 if");
                break;
            }

            //Проверяем под кораблем
            if (x-1+i < 9 && x-1+i > 0 && y+size < 9 && map.getCellStatus(x - 1 + i, y + size) == 1) {
                count++;
                //System.out.println("5 if");
                break;
            }
        }
        return count;
    }

    private int checkFreedomCellHorizont(int x, int y, int size){
        int count = 0;

        for (int i = x; i < x+size ; i++) {
            //Проверяем место куда ставим палубу
            if (map.getCellStatus(i,y) == 1) {
                count++;
                //System.out.println("1h if");
                break;
            }

            //Промеряем место сверху от корабля
            if (y > 0 && map.getCellStatus(i, y - 1) == 1) {
                count++;
                //System.out.println("2h if");
                break;
            }

            //Проверяем место снизу от корабля
            if (y < 9 && map.getCellStatus(i, y + 1) == 1) {
                count++;
                //System.out.println("3h if");
                break;
            }
        }

        for (int i = 0; i < 3; i++) {
            //Проверяем слева от корабля
            if (y-1+i > 0 && y-1+i < 9 && x > 0 && map.getCellStatus(x - 1, y-1+i) == 1) {
                count++;
                //System.out.println("4 if");
                break;
            }

            //Проверяем справа от кораблем
            if (y-1+i < 9 && y-1+i > 0 && x+size < 9 && map.getCellStatus(x+size, y-1+i) == 1) {
                count++;
                //System.out.println("5 if");
                break;
            }
        }
        return count;
    }
}