package com.dealsandcouponsfinder.profilemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.dealsandcouponsfinder.profilemanagement.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String>{

}

