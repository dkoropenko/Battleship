package Logic;

/**
 * Created by Диман on 12.11.2015.
 */
public class Start {

    public static void main(String[] args) {
        Ship ship = new Ship();
        Map map = new Map();

        int[] deckCoordinats;

        //Устанавливаем значение палуб корабля.
        ship.setType(1);

        //Устанавливаем координаты палуб корабля
        for (int i = 0; i < ship.getType(); i++) {
            ship.setLocation("vertical");
            deckCoordinats = ship.getLocation(i);

            map.setLocation(deckCoordinats[0], deckCoordinats[1]);
        }

        for (int i = 0; i < map.getCell(); i++) {
            System.out.println(map.getLocations(i)[0] +" "+ map.getLocations(i)[1]);
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
