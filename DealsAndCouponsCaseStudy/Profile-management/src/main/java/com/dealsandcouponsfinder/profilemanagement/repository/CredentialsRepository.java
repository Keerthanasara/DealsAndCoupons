package com.dealsandcouponsfinder.profilemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.dealsandcouponsfinder.profilemanagement.model.Credentials;

public interface CredentialsRepository extends MongoRepository<Credentials, String>{

}
