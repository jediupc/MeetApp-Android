package joandev.jedimeetingsapp.ui.MeetingList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import joandev.jedimeetingsapp.R;

public class MeetingListActivity extends Activity implements MeetingView{

      /*Color corresponde:
        0 --> formacio
        1 --> marketing
        2 --> cofi
        3 --> rrhh
        4 --> sistemas
    */

    private MeetingListPresenter presenter;

    private RecyclerView mRecyclerView;
    private MeetingAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Meeting> datos;

    @InjectView(R.id.item1) FloatingActionButton button1;
    @InjectView(R.id.item2) FloatingActionButton button2;
    @InjectView(R.id.item3) FloatingActionButton button3;
    @InjectView(R.id.item4) FloatingActionButton button4;
    @InjectView(R.id.item5) FloatingActionButton button5;
    @InjectView(R.id.item6) FloatingActionButton button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        ButterKnife.inject(this);

        //We fill datos with some content
        datos = new ArrayList<Meeting>();
        generateRandomContent();

        presenter = new MeetingListPresenterImpl(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.list2);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MeetingAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);

        button1.setIcon(R.drawable.cofi);
        button2.setIcon(R.drawable.rrhh);
        button3.setIcon(R.drawable.sistemas);
        button4.setIcon(R.drawable.formacio);
        button5.setIcon(R.drawable.marketing);
        button6.setIcon(R.drawable.plus);
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

    @OnClick (R.id.item1)
    public void cofiPressed() {
        presenter.filterData(2);
    }
    @OnClick (R.id.item2)
    public void rrhhPressed() {
        presenter.filterData(3);
    }

    @OnClick (R.id.item3)
    public void sistemesPressed() {
        presenter.filterData(4);
    }

    @OnClick (R.id.item4)
    public void formacioPressed() {
        presenter.filterData(0);
    }

    @OnClick (R.id.item5)
    public void marketingPressed() {
        presenter.filterData(1);
    }

    @OnClick (R.id.item6)
    public void plusPressed() {
        Toast.makeText(getApplicationContext(),"Pressed NEW MEETING",Toast.LENGTH_SHORT).show();
    }

    @Override
    public MeetingAdapter getAdapter() {
        return mAdapter;
    }
}
