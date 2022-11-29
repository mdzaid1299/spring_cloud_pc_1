package com.niit.MovieService.repository;

import com.niit.MovieService.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMovieRepository extends MongoRepository<UserModel,String>
{
    UserModel findByEmail(String email);


}
