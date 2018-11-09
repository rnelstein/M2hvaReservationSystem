package com.hva.m2mobi.m2hva_reservationsystem.models;

public class Room {
    private int imgResource;
    private String name;
    private String description;
    private String calendarID;
    private int capacity;
    private boolean availability = true;
    private String time;

    public Room(int imgResource, String name, String description, String calendarID, int capacity) {
        this.imgResource = imgResource;
        this.name = name;
        this.description = description;
        this.calendarID = calendarID;
        this.time = "10:00";
        this.capacity = capacity;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCalendarID() {
        return calendarID;
    }

    public void setCalendarID(String calendarID) {
        this.calendarID = calendarID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
