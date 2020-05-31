package com.example.asistensi1dan2tahap1.models;

public class Slide {

    private int image ;
    private String title;
    private String streamingLink;
    // Add more field depand on whay you wa&nt ...


    public Slide(int image, String title, String streamingLink) {
        this.image = image;
        this.title = title;
        this.streamingLink = streamingLink;
    }


    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
