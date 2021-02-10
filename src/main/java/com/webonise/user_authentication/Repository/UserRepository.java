package com.webonise.user_authentication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.webonise.user_authentication.models.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{
	UserModel findByUsername(String username);

}
