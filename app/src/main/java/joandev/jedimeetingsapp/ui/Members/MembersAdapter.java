package joandev.jedimeetingsapp.ui.Members;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import joandev.jedimeetingsapp.R;
import joandev.jedimeetingsapp.domain.model.Member;

/**
 * Created by Carles on 14/5/2015.
 */
public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.MembersViewHolder>{
    private  ArrayList<Member> members;
    OnItemClickListener mItemClickListener;


    public MembersAdapter(ArrayList<Member> data) {
        this.members = data;
    }

    @Override
    public MembersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rowlayout_member, parent, false);
        return new MembersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MembersAdapter.MembersViewHolder holder, int position) {
        Member member =  members.get(position);
        holder.name.setText(member.getName());
        holder.position.setText(member.getPosition());
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class MembersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView position;
        public LinearLayout casella;
        //public ImageView avatar;

        public MembersViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.memberName);
            this.position = (TextView) v.findViewById(R.id.memberPosition);
            //TODO: posar la imatge descarregada del ERP
            this.casella = (LinearLayout) v.findViewById(R.id.memberCasella);
            casella.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}
