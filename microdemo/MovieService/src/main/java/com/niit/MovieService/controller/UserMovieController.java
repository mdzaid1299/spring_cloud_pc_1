package com.niit.MovieService.controller;

import com.niit.MovieService.exception.UserAlreadyExistsException;
import com.niit.MovieService.exception.UserNotFoundException;
import com.niit.MovieService.model.Movie;
import com.niit.MovieService.model.UserModel;
import com.niit.MovieService.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usermovieapp/user")
public class UserMovieController
{

    @Autowired
    private UserMovieService userService;

    // http://localhost:64100/usermovieapp/user/register   [post]
    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserModel user) throws UserAlreadyExistsException {
        try{
            user.setMovieList(new ArrayList<>());
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        }
        catch(Exception ex){
            throw new UserAlreadyExistsException();
        }
    }

    // http://localhost:64100/usermovieapp/user/addmovie/a@a.com    [put]
    @PutMapping("/addmovie/{email}")
    public ResponseEntity<?> addMovieToUser(@PathVariable String email, @RequestBody Movie movie) throws UserNotFoundException {
        try{
            return new ResponseEntity<>(userService.addMovieForUser(email,movie), HttpStatus.OK);
        }
        catch(Exception ex){
            throw new UserNotFoundException();
        }
    }

}
