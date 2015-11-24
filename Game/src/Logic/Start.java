package Logic;

/**
 * Created by Диман on 12.11.2015.
 */
public class Start {
    public static void main(String[] args) {
        Map map = new Map(10);
        GroupingShip logic = new GroupingShip(map);
        logic.groupShip();
    }
}
