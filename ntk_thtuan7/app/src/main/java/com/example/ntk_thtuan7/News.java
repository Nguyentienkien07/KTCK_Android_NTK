package com.example.ntk_thtuan7;

public class News {
    private int resourceId, resourceNews;
    private String name;

    public News(int resourceId, int resourceNews, String name) {
        this.resourceId = resourceId;
        this.resourceNews = resourceNews;
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceNews() {
        return resourceNews;
    }

    public void setResourceNews(int resourceNews) {
        this.resourceNews = resourceNews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
