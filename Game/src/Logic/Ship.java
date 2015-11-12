package Logic;

/**
 * Created by Диман on 12.11.2015.
 */
public class Ship {
    private int[] location;

    public void setLocation(int[] x){
        location = x;

        System.out.print("numbers: ");
        for (int i = 0; i < this.location.length ; i++) {
            System.out.print(this.location[i] + " ");
        }
    }

    public boolean checkHit(int location){
        for (int i = 0; i < this.location.length ; i++) {
            if (this.location[i] == location){
                this.location[i] = 11;
                return true;
            }
        }
        return false;
    }
}
