package com.example.asistensi1dan2tahap1.models;

import java.util.ArrayList;

public class Movie {

    private String title;
    private int description;
    private int thumbnail;
    private String studio;
    private String rating;
    private String streamingLink;
    private int coverPhoto;
    private String min;
    private String genre;
    private String director;
    private String writer;
    private String stars;
    private String play;
    private String producer;
    private ArrayList<Star> star;



    public Movie(String title, int thumbnail, int coverPhoto,  int description, String min, String genre, String producer, String director, String writer, String stars, String play, String rating, String studio, String streamingLink, ArrayList<Star> star) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
        this.description = description;
        this.min = min;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.stars = stars;
        this.play = play;
        this.producer = producer;
        this.rating = rating;
        this.studio = studio;
        this.streamingLink = streamingLink;
        this.star = star;
    }





    public Movie(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public ArrayList<Star> getStar() {
        return star;
    }

    public void setStar(ArrayList<Star> star) {
        this.star = star;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }


    public String getProducer() {
        return producer;
    }


    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public String getRating() {
        return rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
