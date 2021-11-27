package com.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private  int id;
    private String name;
    private String singer;
    private MultipartFile link;

    public SongForm() {
    }

    public SongForm(int id, String name, String singer, MultipartFile link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }
}
