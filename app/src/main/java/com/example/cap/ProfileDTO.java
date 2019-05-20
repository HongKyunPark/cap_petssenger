package com.example.cap;

import android.graphics.drawable.Drawable;

public class ProfileDTO {
    private Drawable image;
    private String date;
    private String content;

    public ProfileDTO() {
    }

    public ProfileDTO(Drawable image, String date, String content) {
        this.image = image;
        this.date = date;
        this.content = content;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
