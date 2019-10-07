package com.intuit.demo.repositories;

import com.intuit.demo.models.Follow;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * MongoDB repository for Follow entity.
 * @author  Urvashi Heda
 */
@Repository
public interface FollowRepository extends MongoRepository<Follow, ObjectId> {
    public Follow findByUsername(String name);
}
