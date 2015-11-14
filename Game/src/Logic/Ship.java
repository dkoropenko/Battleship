package Logic;

import java.util.ArrayList;

/**
 * Created by Диман on 12.11.2015.
 */
public class Ship {
    private int type = 0;
    private int hits = 0;
    private int deck = 0;
    private ArrayList<String[]> deckArrLoc;
    String[] location;

    public Ship(){
        type = 0;
        hits = 0;
        deck = 0;
        deckArrLoc = new ArrayList<>();
    }

    public void setOptions (int type, int deck){
        this.type = type;
        this.deck = deck;
    }

    //public  getLocation(){
     //   return location;
    //}

    public void setLocation(int deck){
        location= new String[2];

        for (int i = 0; i < deck; i++) {
            location[0] = "B";
            location[1] = "1";

            deckArrLoc.add(i,location);
        }
    }

    public int getHits(){
        return this.hits;
    }

    public int getDeck(){
        return this.deck;
    }

    public int checkHits(String[] hit){

        String[] checkHit = new String[];


        for (int i = 0; i < this.deck; i++) {
            checkHit = this.deckArrLoc.get(i);

            if (checkHit[0].equals(hit[0]) && checkHit[1].equals(hit[1])){
                return 1;
            }
            else {
                return 0;
            }
        }

    }

    /*
    public int checkLive(){
        if (this.hits == this.deck){
            return 0;
        }
        else {
            return 1;
        }
    }*/

}
