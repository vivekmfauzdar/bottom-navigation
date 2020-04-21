package com.example.to_dowithfirebase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;

    List<Notes> noteslist;

    public CourseAdapter(List<Notes> notesList, Context context)
    {

        this.noteslist=notesList;
        this.context=context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item,parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        final Notes data = noteslist.get(position);
        holder.title.setText(data.getTitle());
        holder.desc.setText(data.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ViewNotes.class);
                i.putExtra("id", data.getId());
                i.putExtra("title", data.getTitle());
                i.putExtra("desc", data.getDesc());
                context.startActivity(i);

            }
        });




    }

    @Override
    public int getItemCount()
    {
        return noteslist.size();
    }

    public  class CourseViewHolder extends RecyclerView.ViewHolder
    {

        TextView title,desc;

        public CourseViewHolder(View itemview)
        {
            super(itemview);

            title=itemview.findViewById(R.id.title);
            desc=itemview.findViewById(R.id.desc);


        }
    }
}
