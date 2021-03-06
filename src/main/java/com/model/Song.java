package com.model;

import javax.persistence.*;

@Entity
@Table
public class Song implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private String singer;
    private String link;

    public Song(int id, String name, String singer, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.link = link;
    }

    public Song(String name, String singer, String link) {
        this.name = name;
        this.singer = singer;
        this.link = link;
    }

    public Song() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
