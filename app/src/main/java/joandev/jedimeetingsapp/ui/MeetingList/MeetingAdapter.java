package joandev.jedimeetingsapp.ui.MeetingList;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.util.ArrayList;
import java.util.Arrays;

import joandev.jedimeetingsapp.R;

/**
 * Created by marcos on 28/04/2015.
 */
public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {
    private ArrayList<Meeting> data;
    private ArrayList<Meeting> complete;

    public MeetingAdapter(ArrayList<Meeting> d){
        this.data = new ArrayList<Meeting>(d);
        this.complete = new ArrayList<Meeting>(d);
    }

    /*Color corresponde:
            0 --> formacio
            1 --> marketing
            2 --> cofi
            3 --> rrhh
            4 --> sistemas
    */

    public TypedArray drawables;
    boolean[] filtereds = new boolean[5];

    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        drawables = viewGroup.getContext().getResources().obtainTypedArray(R.array.avatar_imgs);
        View view = inflater.inflate(R.layout.rowlayout, viewGroup, false);
        Arrays.fill(filtereds, false);
        return new MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingViewHolder holder, int i) {
        Meeting m = data.get(i);
        holder.avatar.setImageDrawable(drawables.getDrawable(m.getDpt()));
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
        public ImageView avatar;
        public TextView subject;
        public TextView hour;
        public TextView day;
        public TextView month;

        public MeetingViewHolder(View v) {
            super(v);
            //TODO se puede usar BK en viewholder?

            avatar = (ImageView) v.findViewById(R.id.dpt);
            subject = (TextView) v.findViewById(R.id.subject);
            hour = (TextView) v.findViewById(R.id.hour);
            day = (TextView) v.findViewById(R.id.day);
            month = (TextView) v.findViewById(R.id.month);

        }
    }


    /*Color corresponde:
        0 --> formacio
        1 --> marketing
        2 --> cofi
        3 --> rrhh
        4 --> sistemas
    */
    int last = -1;
    public void filterData(int dpt){
        if (last != dpt) {
            data.clear();
            //borramos todo lo que no sea dpt
            for (Meeting m : complete) {
                if (m.getDpt() == dpt) {
                    data.add(m);
                }
            }
            last = dpt;
        }
        else{
            last = -1 ;
            data.clear();
            data.addAll(this.complete);
        }
        notifyDataSetChanged();
    }
}
