package homeexercises.donateapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import homeexercises.donateapp.R;
import homeexercises.donateapp.models.Donation;

/**
 * Created by John on 12/09/2017.
 */

public class Base  extends AppCompatActivity{

    public final int target = 10000;
    public int totalDonated =0;
    public static List<Donation> donations = new ArrayList<Donation>();

    public boolean newDonation(Donation donation){
        boolean targetAchieved = totalDonated > target;
        if(!targetAchieved){
            donations.add(donation);
            totalDonated += donation.amount;
        }else{
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        }
        return targetAchieved;
    }//end of boolean

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }//end of OnCreate

    @Override
    public boolean onPrepareOptionsMenu (Menu menu){
        super.onPrepareOptionsMenu(menu);
        MenuItem report = menu.findItem(R.id.menuReport);
        MenuItem donate = menu.findItem(R.id.menuDonate);

        if(donations.isEmpty())
            report.setEnabled(false);
        else
            report.setEnabled(true);

        if(this instanceof Donate){
            donate.setVisible(false);
            if(!donations.isEmpty())
                report.setVisible(true);
        }
        else {
            report.setVisible(false);
            donate.setVisible(true);
        }

        return true;
    }//end of onPrepare

    public void report(MenuItem item)
    {
        startActivity (new Intent(this, Report.class));
    }

    public void donate(MenuItem item)
    {
        startActivity (new Intent(this, Donate.class));
    }


    public void reset(MenuItem item){

    }

}//end of class
