package homeexercises.donateapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import homeexercises.donateapp.R;
import homeexercises.donateapp.models.Donation;


public class Report extends Base
{
    ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        listView = (ListView) findViewById(R.id.reportList);
        DonationAdapter adapter = new DonationAdapter(this, donations);
        listView.setAdapter(adapter);
    }//end of OnCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds item to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }//end of Options Menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuDonate : startActivity (new Intent(this, Donate.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}//end of class

class DonationAdapter extends ArrayAdapter<Donation>
{
    private Context context;
    public List<Donation> donations;

    public DonationAdapter(Context context, List<Donation> donations){
        super(context, R.layout.row_donate, donations);
        this.context = context;
        this.donations = donations;

    }//end of constructor

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View     view       = inflater.inflate(R.layout.row_donate, parent, false);
        Donation donation   = donations.get(position);
        TextView amountView = (TextView) view.findViewById(R.id.row_amount);
        TextView methodView = (TextView) view.findViewById(R.id.row_method);

        amountView.setText("£" + donation.amount);
        methodView.setText(donation.method);

        return view;
    }//getview

    @Override
    public int getCount(){
        return donations.size();
    }//getcount
}
