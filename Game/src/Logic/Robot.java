package Logic;

import java.util.ArrayList;

/**
 * Created by koropenkods on 07.12.2015.
 */
public class Robot extends Logic {
    //Выбор сложности ИИ
    private String difficult;

    //Переменная для определения
    //ориентации корабля на поле.
    private String orientation;

    //Введенные координаты
    private int x,y;
    private int startX, startY;

    //Сигнализация о попадании в корабль
    private int hit, hits;
    private int getit;

    //Количество свободных (не стрелянных) ячеек карты
    ArrayList<Integer[]> freeCell;


    public Robot (Map map, ArrayList<Ship> ships){
        super(map,ships);
        orientation = "";
        freeCell = new ArrayList<>();
        hit = 0;
        getit = 0;
    }

    //Указываем уровень сложности игры.
    public void setDifficult(String difficult){
        this.difficult = difficult;
    }

    public int doShoot() {
        //В зависимости от сложности выбираем
        //Стиль игры за компьютер.
        switch (difficult){
            case "easy":
                this.easyDiffucult();
                break;
            case "normal":
                this.normalDiffucult();
                break;
        }

        //Проверяем введенные данные на попадание.
        if (checkHit(x, y)){
            hit = 1;
            return 2;
        }
        else{
            x = startX;
            y = startY;
            return 1;
        }
    }

    //Простая сложность.
    //Компьютер стреляет рандомно
    //и добивает корабли
    private void easyDiffucult(){

        //Если добили корабль, то бьем опять случайно
        if (hit == 1 && ships.get(shipID).getHits() == ships.get(shipID).getSize()) {
            hit = 0;
            getit = 0;
            orientation = "";
        }

        //Если нет попадания в корабль, то бьем случайно
        if (hit == 0){
            //Записываем все неотстреленные клетки
            //А так же где есть корабли
            for (int i = 0; i < map.getSize(); i++) {
                for (int j = 0; j < map.getSize(); j++) {
                    if (map.getCellStatus(j,i) < 2) {
                        freeCell.add(new Integer[]{j,i});
                    }
                }
            }

            //Случайным образом выбираем куда стрелять
            int i = (int)(Math.random() * freeCell.size());
            x = freeCell.get(i)[0];
            y = freeCell.get(i)[1];

            //Если мы попали в корабль, то записываем координаты
            //этой палубы.
            startX = x;
            startY = y;

            System.out.println("StartX = "+ startX);
            System.out.println("StartY = "+ startY);

            //Очищаем коллекцию пустых клеток.
            freeCell.clear();
        }
        //Если ранили корабль, то добиваем.
        else
        {
            System.out.println("Добиваем корабль.");

            if (getit == 1){
                System.out.println("Попали, ёпта )))");
                if (x < startX || x > startX) orientation = "horizont";
                else orientation = "vertical";

                System.out.println("Ориентация корабля: "+ orientation);


                //Осталось этот свитч доделать и обстрел готов!!!!
                switch (orientation){
                    case "horizont":
                        if (map.getCellStatus(x,y)==3){
                            startX += 1;
                            x = startX;
                        }
                        else
                            x -= 1;
                        break;
                    case "vertical":
                        if (map.getCellStatus(x,y) == 3){
                            startY += 1;
                            y = startY;
                        }
                        else y -= 1;
                }

            }
            else{
                x = startX; y = startY;

                System.out.println("Обстрел вокруг корабля");
                if (x > 0 && map.getCellStatus(x - 1, y) <= 1){
                    System.out.println("Ячейка слева ОГОНЬ");
                    x = x - 1;
                }
                else if (y > 0 && map.getCellStatus(x,y-1) <= 1) {
                    System.out.println("Ячейка сверху ОГОНЬ");
                    y = y - 1;
                }
                else if (x < 9 && map.getCellStatus(x+1,y) <= 1) {
                    System.out.println("Ячейка справа ОГОНЬ");
                    x = x + 1;
                }
                else if (y < 9 && map.getCellStatus(x,y+1) <= 1){
                    System.out.println("Ячейка сниз ОГОНЬ");
                    y = y + 1;
                }

                if (map.getCellStatus(x,y) == 1) {
                    getit = 1;
                }
            }
        }
    }

    private void normalDiffucult(){
        boolean count = true;

        x = (int)(Math.random() * map.getSize());
        y = (int)(Math.random() * map.getSize());

        while (count){
            if (map.getCellStatus(x,y) > 1){
                x = (int)(Math.random() * map.getSize());
                y = (int)(Math.random() * map.getSize());
            }
            else count = false;
        }
    }
}
