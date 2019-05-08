package com.will_russell.myfeed;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Story {

    private String title;
    private String content;
    private ArrayList<Bitmap> images;
    private String source;
    private Bitmap sourceLogo;
    private String date;
    private String[] tags;
    
    public static List<Story> stories = new ArrayList<>();

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
    
    public Story(String title, String content, String source) {
        this.title = title;
        this.content = content;
        this.images = new ArrayList<>();
        this.source = source;
    }
    
    public Story(String title, String content, String source, Bitmap sourceLogo) {
        this.title = title;
        this.content = content;
        this.images = new ArrayList<>();
        this.source = source;
        this.sourceLogo = sourceLogo;
    }

    public Story(String title, String content, Bitmap image, String source, Bitmap sourceLogo) {
        this.title = title;
        this.content = content;
        this.images = new ArrayList<>();
        this.images.add(image);
        this.source = source;
        this.sourceLogo = sourceLogo;
    }

    public Story(String title, String content, ArrayList<Bitmap> images, String source, Bitmap sourceLogo) {
        this.title = title;
        this.content = content;
        this.images = images;
        this.source = source;
        this.sourceLogo = sourceLogo;
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

    public String getSource() {
        return source;
    }

    public Bitmap getSourceLogo() {
        return sourceLogo;
    }

    public String getDate() {
        return date;
    }

    public String[] getTags() {
        return tags;
    }

    public String getTag(int index) {
        return tags[index];
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

    public void setSource(String source) {
        this.source = source;
    }

    public void setSourceLogo(Bitmap sourceLogo) {
        this.sourceLogo = sourceLogo;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setTag(int index, String tag) {
        tags[index] = tag;
    }
}
