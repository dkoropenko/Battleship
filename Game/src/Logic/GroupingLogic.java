package Logic;

import java.util.ArrayList;

/**
 * Created by ����� on 18.11.2015.
 */
public class GroupingLogic {
    private ArrayList<Ship> ships;
    private Map map;

    public GroupingLogic(){

        //�������������� �����.
        map = new Map();
        map.initCell();

        //�������������� �������.
        ships = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            ships.add(j,new Ship());
        }
    }

    public void setShipTypes(){
        int count = 0;
        int y = 4;

        while (count < 10){
            ships.get(count).setType(y);

            count++;
            if (count == 1 || count == 2) y = 3;
            if (count >= 3 && count < 6) y = 2;
            if (count >= 6) y = 1;
        }
    }

    //����� �������� ������ � ����������� �����.
    public boolean checkFreedomCell(int z, int x, int y){

        if (map.checkBusyCell(x,y)){
            ships.get(z).setDeckLocation(x, y);
            map.setShipLocation(x,y);
            return false;
        }
        return true;
    }


    //�������� ��������� ����� ��� ������ ������
    //���������������� �������
    public void GroupLogic(){

        //choose - ����� ������������� ��� ��������������� ���������.
        //0 - �� �����������
        //1 - �� ���������
        int choose;

        //���������� ��� ������ ������.
        int x,y;
        boolean finish;

        for (int z = 0; z < 10; z++) {
            choose = 1 + (int)(Math.random()*100);
            finish = true;

            while (finish){
                if (choose > 50){
                    //��������� ���������� ��� ������ ������.
                    //10 - ships.get(z).getType() - �������� ������ �� �������
                    x = (int)(Math.random()* (10));
                    y = (int)(Math.random()* (10 - ships.get(z).getType()));

                    for (int i = y; i < ships.get(z).getType()+y; i++) {
                        //� ����������� �� ��������������� ��� �������������
                        //������������ ��������� ���� ��� � ������������ �� ������.
                        finish = this.checkFreedomCell(z,x,i);
                    }
                }
                else {
                    x = (int)(Math.random()* (10 - ships.get(z).getType()));
                    y = (int)(Math.random()* (10));

                    for (int i = x; i < ships.get(z).getType()+x; i++) {
                        finish = this.checkFreedomCell(z,i,y);
                    }
                }
            }
        }

        for (int i = 0; i < ships.get(0).getType() ; i++) {
            System.out.println("X:" + ships.get(0).getLocation(i)[0] + " Y:" + ships.get(0).getLocation(i)[1]);
        }

        map.printMap();
    }
}