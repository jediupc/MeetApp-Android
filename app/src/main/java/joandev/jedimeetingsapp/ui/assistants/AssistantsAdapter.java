package joandev.jedimeetingsapp.ui.assistants;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import joandev.jedimeetingsapp.R;
import joandev.jedimeetingsapp.domain.model.Assistant;

/**
 * Created by joanbarroso on 30/4/15.
 */
public class AssistantsAdapter extends RecyclerView.Adapter<AssistantsAdapter.AssistantsViewHolder>{
    private  ArrayList<Assistant> assistants;
    OnItemClickListener mItemClickListener;


    public AssistantsAdapter (ArrayList<Assistant> data) {
        this.assistants = data;
    }

    @Override
    public AssistantsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rowlayout_assistant, parent, false);
        return new AssistantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AssistantsAdapter.AssistantsViewHolder holder, int position) {
        Assistant assistant =  assistants.get(position);
        holder.name.setText(assistant.getName());
        holder.position.setText(assistant.getPosition());
        holder.assisted.setChecked(assistant.isAssisted());
    }

    @Override
    public int getItemCount() {
        return assistants.size();
    }

    public class AssistantsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView position;
        public Switch assisted;
        //public ImageView avatar;

        public AssistantsViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.assistantName);
            this.position = (TextView) v.findViewById(R.id.assistantPosition);
            this.assisted = (Switch) v.findViewById(R.id.assistantAssisted);
            //todo poner el avatar descargado del ERP
            assisted.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
    public interface OnItemClickListener {
        public void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}
