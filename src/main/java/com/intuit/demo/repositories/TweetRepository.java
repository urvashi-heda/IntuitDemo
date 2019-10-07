package com.intuit.demo.repositories;

import com.intuit.demo.models.Tweet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Set;

/**
 * MongoDB repository for Tweet entity.
 * @author  Urvashi Heda
 */
@Repository
public interface TweetRepository extends MongoRepository<Tweet, ObjectId> {
    public ArrayList<Tweet> findByAuthorOrderByPostDateDesc(String name);
    public ArrayList<Tweet> findFirst100ByAuthorInOrderByPostDateDesc(Set<String> authorName);
}
