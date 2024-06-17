package com.example.catApp.domain;


import lombok.Data;

@Data
public final class Image {
    public String id;
    public Integer width;
    public Integer height;
    public String url;
}
