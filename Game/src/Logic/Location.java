package Logic;

/**
 * Created by Диман on 14.11.2015.
 */
public class Location {
    private String[] location;

    public void setLocation (int deck){
        int count = deck*2;
        location = new String[count];


        for (int i = 0; i < count; i+=2) {
            this.location[i] = "B";
            this.location[i+1] = "1";
        }
    }

    public String[] getLocation(){
        return this.location;
    }
}
