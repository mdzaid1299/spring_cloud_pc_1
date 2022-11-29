package com.niit.MovieService.service;

import com.niit.MovieService.exception.UserAlreadyExistsException;
import com.niit.MovieService.exception.UserNotFoundException;
import com.niit.MovieService.model.Movie;
import com.niit.MovieService.model.UserModel;

public interface UserMovieService
{
    public abstract UserModel addUser(UserModel user) throws UserAlreadyExistsException;
    public abstract UserModel addMovieForUser(String email, Movie movie)throws UserNotFoundException;

}
