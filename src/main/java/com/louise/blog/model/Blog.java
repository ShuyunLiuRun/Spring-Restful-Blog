package com.louise.blog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

//model作用大概是存储页面数据？
public class Blog {
    private  UUID id;
    private  String title;
    private  String body;

    public Blog() {
    }

    public Blog(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title,
                @JsonProperty("body") String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
