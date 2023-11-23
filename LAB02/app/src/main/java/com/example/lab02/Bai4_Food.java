package com.example.lab02;


public class Bai4_Food {
    private String Name;
    private int Thumbnail;
    private boolean isPromotion;

    public Bai4_Food() {
    }

    public Bai4_Food(String name, int thumbnail, boolean isPromotion) {
        Name = name;
        Thumbnail = thumbnail;
        this.isPromotion = isPromotion;
    }

    public Bai4_Food(String name, int thumbnail) {
        Name = name;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
    }
}
