package com.example.asistensi1dan2tahap1.models;

import java.util.ArrayList;

public class TVShow {
    private String title;
    private int description;
    private int thumbnail;
    private int coverPhoto;
    private String rating;
    private String streamingLink;
    private String min;
    private String genre;
    private String creator;
    private String play;
    private String studio;
    private String stars;
    private int episode;
    private int season;
    private ArrayList<Star> star;


    public TVShow(String title, int description, int thumbnail, int coverPhoto, String rating, String streamingLink, String min, String genre, String creator, String play, String studio, String stars, int episode, int season, ArrayList<Star> star) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
        this.rating = rating;
        this.streamingLink = streamingLink;
        this.min = min;
        this.genre = genre;
        this.creator = creator;
        this.play = play;
        this.studio = studio;
        this.stars = stars;
        this.episode = episode;
        this.season = season;
        this.star = star;
    }


    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public ArrayList<Star> getStar() {
        return star;
    }

    public void setStar(ArrayList<Star> star) {
        this.star = star;
    }
}
