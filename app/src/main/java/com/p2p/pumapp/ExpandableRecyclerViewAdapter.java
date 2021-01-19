package com.p2p.pumapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {

    private LinkedList<ViewItem> viewItemLinkedList;
    private Context context;

    public ExpandableRecyclerViewAdapter(LinkedList<ViewItem> viewItemLinkedList, Context context){
        this.viewItemLinkedList = viewItemLinkedList;
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
        ViewItem viewItem = viewItemLinkedList.get(position);
        holder.category.setText(viewItem.getCategoryTitle());
        holder.info1.setText(viewItem.getInfo1());
        holder.info2.setText(viewItem.getInfo2());
        holder.info3.setText(viewItem.getInfo3());

        boolean isExpandable = viewItemLinkedList.get(position).isExpandable();
        holder.parentLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        if(!MainActivity.check1){
            holder.info1.setVisibility(View.GONE);
        }
        else{
            holder.info1.setVisibility(View.VISIBLE);
        }
        if(!MainActivity.check2){
            holder.info2.setVisibility(View.GONE);
        }
        else{
            holder.info2.setVisibility(View.VISIBLE);
        }
        if(!MainActivity.check3){
            holder.info3.setVisibility(View.GONE);
        }
        else{
            holder.info3.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return viewItemLinkedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        TextView info1;
        TextView info2;
        TextView info3;
        RelativeLayout parentLayout;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.categoryTitle);
            info1 = itemView.findViewById(R.id.info1);
            info2 = itemView.findViewById(R.id.info2);
            info3 = itemView.findViewById(R.id.info3);

            parentLayout = itemView.findViewById(R.id.parent_layout);
            linearLayout = itemView.findViewById(R.id.linearLayout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewItem viewItem = viewItemLinkedList.get(getAdapterPosition());
                    viewItem.setExpandable(!viewItem.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
