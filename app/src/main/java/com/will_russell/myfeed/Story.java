package com.will_russell.myfeed;

import java.util.ArrayList;
import java.util.List;

public class Story {

    private String title;
    private String content;

    public Story(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<Story> stories = new ArrayList<>();
}
