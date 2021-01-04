package com.p2p.pumapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList <String> categoryTitles= new ArrayList<>();
    private ArrayList <String> categoryItems= new ArrayList<>();
    private ArrayList <String> categoryItems2= new ArrayList<>();
    private ArrayList <String> categoryItems3= new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> categoryTitles, ArrayList<String> categoryItems, ArrayList<String> categoryItems2, ArrayList<String> categoryItems3, Context context) {
        this.categoryTitles = categoryTitles;
        this.categoryItems = categoryItems;
        this.categoryItems2 = categoryItems2;
        this.categoryItems3 = categoryItems3;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryTitle.setText(categoryTitles.get(position));
        holder.categoryItem.setText(categoryItems.get(position));
        holder.categoryItem2.setText(categoryItems2.get(position));
        holder.categoryItem3.setText(categoryItems3.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryTitle;
        TextView categoryItem;
        TextView categoryItem2;
        TextView categoryItem3;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.category_title);
            categoryItem = itemView.findViewById(R.id.category_item);
            categoryItem2 = itemView.findViewById(R.id.category_item2);
            categoryItem3 = itemView.findViewById(R.id.category_item3);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}