package com.example.qrapp;

public class ScanModel {
    private int id;
    private String info;
    private int type;

    public ScanModel(int id, String info, int type) {
        this.id = id;
        this.info = info;
        this.type = type;

    }

    public int getId() {
        return this.id;
    }
    public String getFormattedId() {
        return "ID:" + Integer.toString(this.id);
    }
    public String getInfo() {
        return info;
    }

    public int getType() {
        return type;
    }
}
