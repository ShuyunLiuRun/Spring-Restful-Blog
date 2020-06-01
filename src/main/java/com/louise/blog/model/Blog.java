package com.louise.blog.model;

import com.fasterxml.jackson.annotation.JsonProperty;


//model作用大概是存储页面数据
public class Blog {
    private  int id;
    private  String title;
    private  String body;

    public Blog() {
    }

    public Blog(@JsonProperty("id") int id,
                @JsonProperty("title") String title,
                @JsonProperty("body") String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Blog(@JsonProperty("title")String title,
                @JsonProperty("body")String body) {
        this.title = title;
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
