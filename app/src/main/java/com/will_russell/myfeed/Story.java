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
    private String url;
    
    public static List<Story> stories = new ArrayList<>();

    public Story() {}

    public Story(String title, String content, String date, String url, ArrayList<Bitmap> images) {
        defaultStory(title, content, date, url, images);
    }

    public Story(String title, String content, String date, String url, ArrayList<Bitmap> images, String source, Bitmap sourceLogo) {
        defaultStory(title, content, date, url, images);
        this.source = source;
        this.sourceLogo = sourceLogo;
    }

    public void defaultStory(String title, String content, String date, String url, ArrayList<Bitmap> images) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.url = url;
        this.images = images;
    }

    public void defaultSource(String source, Bitmap sourceLogo) {

    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Bitmap getImage(int index) {
        return images.get(index);
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

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(int index, Bitmap image) {
        this.images.set(index, image);
    }

    public void setImages(ArrayList<Bitmap> images) {
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

    public void setUrl(String url) {
        this.url = url;
    }
}
