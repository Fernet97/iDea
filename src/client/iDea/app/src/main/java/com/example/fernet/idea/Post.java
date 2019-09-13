package com.example.fernet.idea;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {

    private long id;
    private long id_author;
    private String description;
    private int numLike;
    private int numDisLike;
    private String DateHourBorn;
    private ArrayList<String> commenti;


    public Post(long id, long id_author, String description, int numLike, int numDisLike, String dateHourBorn, ArrayList<String> commenti) {
        this.id = id;
        this.id_author = id_author;
        this.description = description;
        this.numLike = numLike;
        this.numDisLike = numDisLike;
        DateHourBorn = dateHourBorn;
        this.commenti = commenti;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_author() {
        return id_author;
    }

    public void setId_author(long id_author) {
        this.id_author = id_author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public int getNumDisLike() {
        return numDisLike;
    }

    public void setNumDisLike(int numDisLike) {
        this.numDisLike = numDisLike;
    }

    public String getDateHourBorn() {
        return DateHourBorn;
    }

    public void setDateHourBorn(String dateHourBorn) {
        DateHourBorn = dateHourBorn;
    }

    public ArrayList<String> getCommenti() {
        return commenti;
    }

    public void setCommenti(ArrayList<String> commenti) {
        this.commenti = commenti;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", id_author=" + id_author +
                ", description='" + description + '\'' +
                ", numLike=" + numLike +
                ", numDisLike=" + numDisLike +
                ", DateHourBorn=" + DateHourBorn +
                ", commenti=" + commenti +
                '}';
    }
}
