package com.p2p.pumapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.ViewHolder> {

    private LinkedList<AppointmentItem> appointmentLinkedList;
    private Context context;

    public AppointmentsAdapter(LinkedList<AppointmentItem> appointmentItemLinkedList, Context context){
        this.appointmentLinkedList = appointmentItemLinkedList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("Expandable", "OnBindViewHolder called");
        AppointmentItem appointmentItem = appointmentLinkedList.get(position);
        holder.title.setText(appointmentItem.getDate());
        String[] arr = appointmentItem.getTimeSlots();
        holder.buttonLayout.removeAllViews();
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            Button button = new Button(context);
            button.setText(str);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            if(i>0){
                params.setMargins(0, 150*i, 0, 0);
            }
            holder.buttonLayout.addView(button, params);
        }
        boolean isExpandable = appointmentLinkedList.get(position).isExpandable();
        holder.buttonLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        if(appointmentLinkedList!=null) {
            return appointmentLinkedList.size();
        }
        else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        RelativeLayout buttonLayout;
        LinearLayout appointmentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.appointmentTitle);

            buttonLayout = itemView.findViewById(R.id.button_layout);
            appointmentLayout = itemView.findViewById(R.id.appointmentLayout);

            appointmentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppointmentItem viewItem = appointmentLinkedList.get(getAdapterPosition());
                    viewItem.setExpandable(!viewItem.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
