package com.example.teatre_app;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookingRVAdapter extends RecyclerView.Adapter<BookingRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<BookingModal> bookingModalArrayList;
    private Context context;

    // constructor
    public BookingRVAdapter(ArrayList<BookingModal> bookingModalArrayList, Context context) {
        this.bookingModalArrayList = bookingModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BookingModal modal = bookingModalArrayList.get(position);
        holder.playNameTV.setText(modal.getPlayName());
        holder.seatingTypeTV.setText(modal.getSeatingType());
        holder.totalSeatsTV.setText(modal.getTotalSeats());
        holder.leadNameTV.setText(modal.getLeadName());
    }

    @Override
    public int getItemCount() {

        return bookingModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView playNameTV, seatingTypeTV, totalSeatsTV, leadNameTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            playNameTV = itemView.findViewById(R.id.idTVPlayName);
            seatingTypeTV = itemView.findViewById(R.id.idTVSeatingType);
            totalSeatsTV = itemView.findViewById(R.id.idTVTotalSeats);
            leadNameTV = itemView.findViewById(R.id.idTVLeadName);
        }
    }
}