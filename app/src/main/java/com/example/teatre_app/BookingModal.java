package com.example.teatre_app;

public class BookingModal {
    private String playName;

    private String seatingType;

    private String totalSeats;

    private String leadName;
    private int id;

    // creating getter and setter methods
    public String getPlayName() { return playName; }

    public void setPlayName(String playName)
    {

        this.playName = playName;
    }

    public String getSeatingType()
    {
        return seatingType;
    }

    public void setSeatingType(String seatingType)
    {

        this.seatingType = seatingType;
    }

    public String getTotalSeats() { return totalSeats; }

    public void setTotalSeats(String totalSeats)
    {

        this.totalSeats = totalSeats;
    }

    public String getLeadName()
    {

        return leadName;
    }

    public void setLeadName(String leadName)
    {

        this.leadName = leadName;
    }

    public int getId() {return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public BookingModal(String playName,
                       String seatingType,
                       String totalSeats,
                       String leadName)
    {
        this.playName = playName;
        this.seatingType = seatingType;
        this.totalSeats = totalSeats;
        this.leadName = leadName;
    }
}