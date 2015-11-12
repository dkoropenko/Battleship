package Logic;

/**
 * Created by Диман on 12.11.2015.
 */
public class Start {

    public static void main(String[] args) {
        Ship one = new Ship();

        int[] location = {2,3,4};

        one.setLocation(location);

        int playerHit, hits=0, loose=0;

        int x =0;
        while(x != 7){

            playerHit = x;

            System.out.println("\nHit " + playerHit + ".");

            if (one.checkHit(playerHit)) {
                hits += 1;
            }
            else {
                System.out.println("Try again!");
                loose += 1;
            }

            if (hits == 3) {
                System.out.println("Player wins.");
                System.out.println("Missed: " + loose);
                break;
            }
            x++;
        }


    }
}
