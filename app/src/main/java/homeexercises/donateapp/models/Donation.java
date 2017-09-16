package homeexercises.donateapp.models;

/**
 * Created by John on 12/09/2017.
 */

public class Donation {
    public int amount;
    public String method;

    public Donation (int amount, String method){
        this.amount = amount;
        this.method = method;
    }//constructor

    public Donation(String method) {
        this.method = method;
    }
}//end of Donation
