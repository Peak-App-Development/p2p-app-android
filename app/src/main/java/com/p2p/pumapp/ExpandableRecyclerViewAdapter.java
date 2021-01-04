package com.p2p.pumapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {

    private LinkedList<Notifications> notificationsLinkedList;
    private Context context;

    public ExpandableRecyclerViewAdapter(LinkedList<Notifications> notificationsLinkedList, Context context){
        this.notificationsLinkedList = notificationsLinkedList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("Expandable", "OnBindViewHolder called");
        Notifications notifications = notificationsLinkedList.get(position);
        holder.category.setText(notifications.getCategoryTitle());
        holder.teachers.setText(notifications.getTeachers());
        holder.text.setText(notifications.getText());
        holder.date.setText(notifications.getDate());

        boolean isExpandable = notificationsLinkedList.get(position).isExpandable();
        holder.parentLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return notificationsLinkedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        TextView teachers;
        TextView text;
        TextView date;
        RelativeLayout parentLayout;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.categoryTitle);
            teachers = itemView.findViewById(R.id.teacher);
            text = itemView.findViewById(R.id.text);
            date = itemView.findViewById(R.id.date);

            parentLayout = itemView.findViewById(R.id.parent_layout);
            linearLayout = itemView.findViewById(R.id.linearLayout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Expandable", "OnClick method called");
                    Notifications notifications = notificationsLinkedList.get(getAdapterPosition());
                    notifications.setExpandable(!notifications.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
