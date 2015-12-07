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
    int hit;


    public Robot (Map map, ArrayList<Ship> ships){
        super(map,ships);
        hit = 0;
        orientation = "horizont";
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
            hit = 0;
            return 2;
        }
        else return 1;
    }

    //Простая сложность.
    //Компьютер стреляет рандомно
    //и добивает корабли
    private void easyDiffucult(){
        boolean count;

        //Если добили корабль, то бьем опять случайно
        if (hit == 1 && ships.get(shipID).getHits() == ships.get(shipID).getSize()) hit = 0;

        if (hit == 0){
            count = true;
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
        else{
            if (orientation.equals("horizont")){
                if (x > 0 && map.getCellStatus(x-1,y) > 1){
                    x -= 1;
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

/*
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
 */