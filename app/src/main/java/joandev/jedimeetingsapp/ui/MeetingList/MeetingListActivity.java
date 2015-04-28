package joandev.jedimeetingsapp.ui.MeetingList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import joandev.jedimeetingsapp.R;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.Random;

public class MeetingListActivity extends Activity {

    private RecyclerView mRecyclerView;
    private MeetingAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Meeting> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        ButterKnife.inject(this);
        //We fill datos with some content
        datos = new ArrayList<Meeting>();
        generateRandomContent();

        mRecyclerView = (RecyclerView) findViewById(R.id.list2);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MeetingAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void generateRandomContent() {
        //this method is provided temporally. Random data is generated to feed the recycler.
        //some arrays for the content
        Random randomGenerator = new Random();
        String[] months = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul",
                "Aug",
                "Sep",
                "Oct",
                "Nov",
                "Dec"
        };
        String[] hours = {
                "17:00","18:00","20:00","09:00","12:30","16:00"
        };

        String[] subjects = {
                "Training Meeting", "Workshop", "Course", "Assembly"
        };

        for (int i = 0; i < 100; ++i){
            Meeting aux = new Meeting();
            aux.setDay(randomGenerator.nextInt(32) + "");
            aux.setDpt(randomGenerator.nextInt(5));
            aux.setHour(hours[randomGenerator.nextInt(6)]);
            aux.setSubject(subjects[randomGenerator.nextInt(4)]);
            aux.setMonth(months[randomGenerator.nextInt(12)]);
            datos.add(i,aux);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meeting_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
