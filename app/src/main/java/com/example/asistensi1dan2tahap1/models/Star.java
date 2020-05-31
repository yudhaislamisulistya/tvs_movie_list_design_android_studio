package com.example.asistensi1dan2tahap1.models;

import java.io.Serializable;

public class Star implements Serializable {
    private int thumbnail;
    private String fullname;
    private String alias;

    public Star(int thumbnail, String fullname, String alias) {
        this.thumbnail = thumbnail;
        this.fullname = fullname;
        this.alias = alias;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAlias() {
        return alias;
    }
}
