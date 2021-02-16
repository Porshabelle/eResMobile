package com.example.eresapplication.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eresapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class EventsAdapter extends FirebaseRecyclerAdapter<EventCalender,EventsAdapter.myViewHolder>
{
    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull EventCalender model) {
        holder.tvEvent.setText(model.getEvent());
        holder.tvMonth.setText(model.getMonth());
        holder.tvDay.setText(model.getDay());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_row_layout,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvEvent;
        TextView tvMonth;
        TextView tvDay;
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvEvent = (TextView)itemView.findViewById(R.id.tvEvent);
            tvMonth = (TextView) itemView.findViewById(R.id.tvMonth);
            tvDay = (TextView) itemView.findViewById(R.id.tvDay);
        }
    }
    public EventsAdapter(@NonNull FirebaseRecyclerOptions options) {
        super(options);
    }
    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}