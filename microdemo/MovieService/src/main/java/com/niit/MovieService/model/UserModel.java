package com.niit.MovieService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class UserModel
{

    private int userid;
    private String uname;
    @Id
    private  String email;
    private List<Movie> movieList;

    public UserModel(){}
    public UserModel(int userid, String uname, String email, List<Movie> movieList) {
        this.userid = userid;
        this.uname = uname;
        this.email = email;
        this.movieList = movieList;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userid=" + userid +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", movieList=" + movieList +
                '}';
    }
}
