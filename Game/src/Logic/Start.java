package Logic;

/**
 * Created by Диман on 12.11.2015.
 */
public class Start {

    public static void main(String[] args) {
        Ship ship = new Ship();

        ship.setType(3);

        for (int i = 0; i < 5; i++) {
            ship.setLocation("horizontal");
            ship.getLocation();
            ship.clearOprions();
            System.out.println();
        }


        /*
        System.out.println(ship.checkHits(new int[]{0, 1}));
        System.out.println(ship.checkHits(new int[]{0, 1}));

        System.out.println(ship.checkHits(new int[]{1, 2}));
        System.out.println(ship.checkHits(new int[]{1, 2}));

        System.out.println(ship.checkHits(new int[]{2, 3}));
        System.out.println(ship.checkHits(new int[]{2, 3}));

        System.out.println(ship.checkHits(new int[]{3, 4}));
        System.out.println(ship.checkHits(new int[]{3, 4}));
        */
    }
}
