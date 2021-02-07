package com.example.eresapplication.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eresapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class UserHelperAdapter extends FirebaseRecyclerAdapter<UserHelperClass,UserHelperAdapter.myViewHolder>
{
    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull UserHelperClass model) {

        holder.tvTitle.setText(model.getTitle());
        holder.tvDescription.setText(model.getDescription());
        holder.tvRole.setText("Posted by: "+model.getRole()+": "+model.getFirstname()+" "+model.getSurname());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitle;
        TextView tvDescription;
        TextView tvRole;
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvRole = (TextView)itemView.findViewById(R.id.tvRole);

        }
    }
    public UserHelperAdapter(@NonNull FirebaseRecyclerOptions options) {
        super(options);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}