package com.rodrigo.damazod.platzigram.model;

/**
 * Created by damazoD on 18/07/2017.
 */

public class Picture {
    String picture;
    String username;
    int time;
    int like;

    public Picture(String picture,String username,int time,int like) {
        this.picture = picture;
        this.username = username;
        this.time = time;
        this.like = like;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
