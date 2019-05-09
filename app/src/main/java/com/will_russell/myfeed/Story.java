package com.will_russell.myfeed;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Story {

    private String title;
    private String content;
    private String summary;
    private Bitmap image;
    private String source;
    private Bitmap sourceLogo;
    private String date;
    private String[] tags;
    private String url;
    
    public static List<Story> stories = new ArrayList<>();

    public Story() {}

    public Story(String title, String content, String summary, String date, String url, Bitmap image) {
        defaultStory(title, content, summary, date, url, image);
    }

    public Story(String title, String content, String summary,  String date, String url, Bitmap image, String source, Bitmap sourceLogo) {
        defaultStory(title, content, summary, date, url, image);
        this.source = source;
        this.sourceLogo = sourceLogo;
    }

    public void defaultStory(String title, String content, String summary, String date, String url, Bitmap image) {
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.date = date;
        this.url = url;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
    }

    public Bitmap getImage() {
        return image;
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

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setImage(Bitmap image) {
        this.image = image;
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
