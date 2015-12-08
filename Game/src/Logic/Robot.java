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

    //Сигнализация о попадании в корабль
    int hit, hits;

    //Количество свободных (не стрелянных) ячеек карты
    ArrayList<Integer[]> freeCell;


    public Robot (Map map, ArrayList<Ship> ships){
        super(map,ships);
        hit = 0;
        orientation = "horizont";
        freeCell = new ArrayList<>();
        hits = 0;
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
        else return 1;
    }

    //Простая сложность.
    //Компьютер стреляет рандомно
    //и добивает корабли
    private void easyDiffucult(){
        //Если добили корабль, то бьем опять случайно
        if (hit == 1 && ships.get(shipID).getHits() == ships.get(shipID).getSize()) hit = 0;

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

            //Очищаем коллекцию пустых клеток.
            freeCell.clear();
        }
        //Если ранили корабль, то добиваем.
        else{
            switch (orientation){
                case "horizont":
                    if (x > 0 && map.getCellStatus(x-1,y) > 1) {
                        x = x - 1;
                        hits++;
                    }
                    if (map.getCellStatus(x,y) > 1 && hit > 0) x = x + hits + 1;
            }

            if (y > 0 && map.getCellStatus(x,y-1) > 1) y = y - 1;
            if (x < 0 && map.getCellStatus(x+1,y) > 1) x = x + 1;
            if (y < 0 && map.getCellStatus(x,y+1) > 1) y = y + 1;
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
