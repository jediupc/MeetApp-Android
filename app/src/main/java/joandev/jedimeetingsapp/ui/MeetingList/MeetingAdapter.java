package joandev.jedimeetingsapp.ui.MeetingList;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.util.ArrayList;

import joandev.jedimeetingsapp.R;

/**
 * Created by marcos on 28/04/2015.
 */
public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {
    private ArrayList<Meeting> data;


    public MeetingAdapter(ArrayList<Meeting> d){
        this.data = d;
    }

    /*Color corresponde:
            0 --> formacio
            1 --> marketing
            2 --> cofi
            3 --> rrhh
            4 --> sistemas
    */
    private String[] colors= {"#8BC34A","#ffffff" ,"#efbc54" ,"#3a3a3c" ,"#2196F3"};

    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.rowlayout, viewGroup, false);
        return new MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingViewHolder holder, int i) {
        Meeting m = data.get(i);
        holder.color.setBackgroundColor(Color.parseColor(colors[m.getDpt()]));
        holder.subject.setText(m.getSubject());
        holder.hour.setText(m.getHour());
        holder.day.setText(m.getDay());
        holder.month.setText(m.getMonth());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    //clase ViewHolder
    public static class MeetingViewHolder extends RecyclerView.ViewHolder {
        public TextView color;
        public TextView subject;
        public TextView hour;
        public TextView day;
        public TextView month;

        public MeetingViewHolder(View v) {
            super(v);
            //TODO se puede usar BK en viewholder?

            color = (TextView) v.findViewById(R.id.dpt);
            subject = (TextView) v.findViewById(R.id.subject);
            hour = (TextView) v.findViewById(R.id.hour);
            day = (TextView) v.findViewById(R.id.day);
            month = (TextView) v.findViewById(R.id.month);

        }
    }
}
