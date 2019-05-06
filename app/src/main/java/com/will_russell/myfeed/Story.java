package com.will_russell.myfeed;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Story {

    private String title;
    private String content;
    private ArrayList<Bitmap> images;

    public Story(String title, String content) {
        this.title = title;
        this.content = content;
        this.images = new ArrayList<>();
    }

    public Story(String title, String content, Bitmap image) {
        this.title = title;
        this.content = content;
        this.images = new ArrayList<>();
        this.images.add(image);
    }

    public Story(String title, String content, ArrayList<Bitmap> images) {
        this.title = title;
        this.content = content;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<Bitmap> getImages() {
        return images;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(ArrayList<Bitmap> images) {
        this.images = images;
    }

    public static List<Story> stories = new ArrayList<>();
}