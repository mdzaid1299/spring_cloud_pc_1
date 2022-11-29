package com.niit.MovieService.model;


import org.springframework.data.annotation.Id;

public class Movie {
    @Id
private int movieid;
private String moviename;
private String actorname;
private float ratings;

    public Movie() {
    }

    public Movie(int movieid, String moviename, String actorname, float ratings) {
        this.movieid = movieid;
        this.moviename = moviename;
        this.actorname = actorname;
        this.ratings = ratings;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getActorname() {
        return actorname;
    }

    public void setActorname(String actorname) {
        this.actorname = actorname;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieid=" + movieid +
                ", moviename='" + moviename + '\'' +
                ", actorname='" + actorname + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
