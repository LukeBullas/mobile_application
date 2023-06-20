package com.example.teatre_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.CheckBox;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class BookingActivity extends AppCompatActivity {

    private EditText playNameEdt, seatingTypeEdt, totalSeatsEdt, leadNameEdt;
    private Button addBookingBtn, readBookingsBtn;

    private CheckBox termsBox;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        playNameEdt = findViewById(R.id.idEdtPlayName);
        seatingTypeEdt = findViewById(R.id.idEdtSeatingType);
        totalSeatsEdt = findViewById(R.id.idEdtTotalSeats);
        leadNameEdt = findViewById(R.id.idEdtLeadName);
        addBookingBtn = findViewById(R.id.idBtnAddBooking);
        readBookingsBtn = findViewById(R.id.idBtnReadBookings);

        termsBox = findViewById(R.id.CheckBox);

        dbHandler = new DBHandler(BookingActivity.this);

        addBookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playName = playNameEdt.getText().toString();
                String seatingType = seatingTypeEdt.getText().toString();
                String totalSeats = totalSeatsEdt.getText().toString();
                String leadName = leadNameEdt.getText().toString();

                if (playName.isEmpty() || seatingType.isEmpty() || totalSeats.isEmpty() || leadName.isEmpty()) {
                    Toast.makeText(BookingActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (termsBox.isChecked()) {
                    dbHandler.addNewBooking(playName, seatingType, totalSeats, leadName);

                    Toast.makeText(BookingActivity.this, "Your booking has been created.", Toast.LENGTH_SHORT).show();
                    playNameEdt.setText("");
                    seatingTypeEdt.setText("");
                    totalSeatsEdt.setText("");
                    leadNameEdt.setText("");
                }else{

                    Toast.makeText(BookingActivity.this, "Terms and conditions need to be accepted to book.", Toast.LENGTH_SHORT).show();

                }
            }
        });

        readBookingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent intent = new Intent(BookingActivity.this,    ViewBookingsActivity.class);
                startActivity(intent);
            }
        });}}