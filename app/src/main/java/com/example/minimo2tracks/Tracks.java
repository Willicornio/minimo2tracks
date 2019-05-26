package com.example.minimo2tracks;

public class Tracks {

    String id;
    String title;
    String singer;


    public Tracks(String id, String title, String single) {
        this.id = id;
        this.title = title;
        this.singer = single;
    }


    public Tracks (){
        this.id = null;
        this.singer = null;
        this.title = null;
    }

    public Tracks(String title, String single) {
        this.id = null;
        this.title = title;
        this.singer = single;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSingle() {
        return singer;
    }

    public void setSingle(String single) {
        this.singer = single;
    }
}
