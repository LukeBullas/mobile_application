package com.example.teatre_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "Booking.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "bookings";
    private static final String ID_COL = "id";
    private static final String PLAY_COL = "play";

    private static final String SEATING_COL = "seating";

    private static final String TOTAL_COL = "description";
    private static final String LEAD_COL = "name";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PLAY_COL + " TEXT,"
                + SEATING_COL + " TEXT,"
                + TOTAL_COL + " TEXT,"
                + LEAD_COL + " TEXT)";

        db.execSQL(query);
    }


    public void addNewBooking(String playName, String seatingType, String totalSeating, String leadName) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(PLAY_COL, playName);
        values.put(SEATING_COL, seatingType);
        values.put(TOTAL_COL, totalSeating);
        values.put(LEAD_COL, leadName);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }


    public ArrayList<BookingModal> readCourses()
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor bookingCourses
                = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<BookingModal> bookingModalArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (bookingCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                bookingModalArrayList.add(new BookingModal(
                        bookingCourses.getString(1),
                        bookingCourses.getString(4),
                        bookingCourses.getString(2),
                        bookingCourses.getString(3)));
            } while (bookingCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        bookingCourses.close();
        return bookingModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}