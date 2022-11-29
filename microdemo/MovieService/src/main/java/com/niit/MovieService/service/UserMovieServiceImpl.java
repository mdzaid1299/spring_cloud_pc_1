package com.niit.MovieService.service;

import com.niit.MovieService.exception.UserAlreadyExistsException;
import com.niit.MovieService.exception.UserNotFoundException;
import com.niit.MovieService.model.Movie;
import com.niit.MovieService.model.UserModel;
import com.niit.MovieService.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserMovieServiceImpl implements UserMovieService {
    @Autowired
    private UserMovieRepository userMovieRepository;

    @Override
    public UserModel addUser(UserModel user) throws UserAlreadyExistsException {
        if (userMovieRepository.findById(user.getEmail()).isPresent()) {

            throw new UserAlreadyExistsException();
        }
        return userMovieRepository.insert(user);

    }


    @Override
    public UserModel addMovieForUser(String email, Movie movie) throws UserNotFoundException {
        if (userMovieRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        UserModel user = userMovieRepository.findByEmail(email);
        if (user.getMovieList() == null) {
            user.setMovieList(Arrays.asList(movie));
        } else {
            List<Movie> movies = user.getMovieList();
            movies.add(movie);
            user.setMovieList(movies);
        }
        return userMovieRepository.save(user);


    }
}