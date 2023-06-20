package com.example.teatre_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewBookingsActivity extends AppCompatActivity {

    private ArrayList<BookingModal> bookingModalArrayList;
    private DBHandler dbHandler;
    private BookingRVAdapter bookingsRVAdapter;
    private RecyclerView bookingsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);

        bookingModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewBookingsActivity.this);

        bookingModalArrayList = dbHandler.readCourses();

        bookingsRVAdapter = new BookingRVAdapter(bookingModalArrayList, ViewBookingsActivity.this);
        bookingsRV = findViewById(R.id.idRVBookings);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewBookingsActivity.this, RecyclerView.VERTICAL, false);
        bookingsRV.setLayoutManager(linearLayoutManager);

        bookingsRV.setAdapter(bookingsRVAdapter);
    }
}