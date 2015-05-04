package joandev.jedimeetingsapp.ui.assistants;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

import joandev.jedimeetingsapp.R;
import joandev.jedimeetingsapp.domain.model.Assistant;
import joandev.jedimeetingsapp.ui.MeetingList.MeetingAdapter;

public class AssistantsActivity extends Activity {

    private RecyclerView mRecyclerView;
    private AssistantsAdapter aAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Assistant> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistants);


        mRecyclerView = (RecyclerView) findViewById(R.id.assistantsList);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

<<<<<<< Updated upstream
        datos = new ArrayList<Assistant>();

=======
        datos = new ArrayList<>();
>>>>>>> Stashed changes
        fillWithRandom();


        aAdapter = new AssistantsAdapter(datos);
        mRecyclerView.setAdapter(aAdapter);
<<<<<<< Updated upstream

=======
        aAdapter.SetOnItemClickListener(new AssistantsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                datos.get(position).setAssisted(!datos.get(position).isAssisted());
            }
        });
>>>>>>> Stashed changes
    }

    private void fillWithRandom() {
        Random randomGenerator = new Random();
        String[] names = {
                "Anna",
                "Marcos",
                "Joan",
                "Freddy-->Nazi",
                "Balastegui",
                "FCJE",
                "Flor",
                "Lucia",
                "Eric",
                "Valen",
                "Albert",
                "Laura"
        };

        String[] position = {
                "Training Manager", "President", "Member", "Soldier", "Libido"
        };

        for (int i = 0; i < 100; ++i) {
            Assistant aux = new Assistant();
            aux.setName(names[randomGenerator.nextInt(12)] + "");
            aux.setPosition(position[randomGenerator.nextInt(5)] + "");
            aux.setAssisted(false);
            datos.add(i, aux);
        }
    }
}
