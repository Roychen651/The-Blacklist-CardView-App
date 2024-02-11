package com.example.theblacklistcardviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    private OnItemClickListener listener; // Declare listener variable

    // Constructor
    public CustomeAdapter(ArrayList<DataModel> dataSet, OnItemClickListener listener) {
        this.dataSet = dataSet;
        this.listener = listener;
    }

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(DataModel item);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textname;
        TextView textversion;
        ImageView imageView;
        OnItemClickListener listener; // Declare listener variable

        public MyViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            textname = itemView.findViewById(R.id.textView);
            textversion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
            this.listener = listener; // Assign listener
            itemView.setOnClickListener(this); // Set click listener
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(dataSet.get(position));
                }
            }
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        MyViewHolder myVHolder = new MyViewHolder(view, listener);
        return myVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        holder.textname.setText(dataSet.get(position).getName());
        holder.textversion.setText(dataSet.get(position).getVersion());
        holder.imageView.setImageResource(dataSet.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
