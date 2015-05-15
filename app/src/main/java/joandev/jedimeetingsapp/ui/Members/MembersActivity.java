package joandev.jedimeetingsapp.ui.Members;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import joandev.jedimeetingsapp.R;
import joandev.jedimeetingsapp.domain.model.Member;

/**
 * Created by Carles on 14/05/2015.
 */

public class MembersActivity extends Activity {
    private RecyclerView mRecyclerView;
    private MembersAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Member> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);


        mRecyclerView = (RecyclerView) findViewById(R.id.membersList);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        datos = new ArrayList<>();

        datos = new ArrayList<>();
        fillWithRandom();


        mAdapter = new MembersAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new MembersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //TODO: Enviar a ProfileInfo (Segarra?)
            }
        });
    }

    private void fillWithRandom() {
        Random randomGenerator = new Random();
        String[] names = {
                "Anna",
                "Marcos",
                "Joan",
                "Fred",
                "Carles",
                "Soler",
                "Flor",
                "Lucia",
                "Eric",
                "Valen",
                "Albert",
                "Laura"
        };

        String[] position = {
                "Cabesa de gitanos", "Cabesa de personas", "Cabesa de narcotrafico", "Cabesa de conosimiento", "Cabesa de cabesas",
                "Cabesa de cables", "Cabesa de dineros", "Cabesa de internet", "Cabesa de nazis"
        };

        for (int i = 0; i < 100; ++i) {
            Member aux = new Member();
            aux.setName(names[randomGenerator.nextInt(12)] + "");
            aux.setPosition(position[randomGenerator.nextInt(5)] + "");
            datos.add(i, aux);
        }
    }
}
