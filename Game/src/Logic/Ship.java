package Logic;

import java.util.ArrayList;

/**
 * Created by ����� on 12.11.2015.
 */
public class Ship {
    //�������� ����� ������ ������� � ��������� "���\������"
    private ArrayList<int[]> deck;

    //�������� ��� �������. ���������� �����.
    private int type;

    //�������� ���������� ��������� �� �������.
    private int hit;

    public Ship(){
        deck = new ArrayList<>();
        type = 0;
        hit = 0;
    }

    public void setType(int a){
        type = a;
    }
    public int getType(){
        return type;
    }

    public void setLocation(String orientation){

        int x = (int) (Math.random()*6);

        if (type == 2 && x > 5)
            x = 6 - x;
        if (type == 3 && x > 4)
            x = 6 - x;
        if (type == 4 && x > 3)
            x = 6 - x;

        if (orientation.equals("vertical"))
        {
            for (int i = 0; i < type; i++) {
                deck.add(new int[]{x, x + i, 1});
            }
        }
        else{
            for (int i = 0; i < type; i++) {
                deck.add(new int[]{x+i, x, 1});
            }
        }

    }

    public void getLocation(){
        for (int i = 0; i < type; i++) {
            System.out.println(deck.get(i)[0] + " " + deck.get(i)[1]);
        }
    }

    public String checkHits(int[] hit){

        for (int i = 0; i < type; i++) {
            if (deck.get(i)[2] == 1){
                if (deck.get(i)[0] == hit[0] && deck.get(i)[1] == hit[1] ){
                    this.hit++;
                    deck.set(i,new int[]{deck.get(i)[0],deck.get(i)[1],0});
                    return "�����";
                }
            }
        }
        return "����";
    }

    public void clearOprions(){
        deck.clear();
       // type = 0;
        hit = 0;
    }
}