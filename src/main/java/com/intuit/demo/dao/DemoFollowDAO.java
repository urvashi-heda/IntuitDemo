package com.intuit.demo.dao;

import com.intuit.demo.exceptions.IncorrectRequestException;
import com.intuit.demo.exceptions.FollowNotAllowedException;
import com.intuit.demo.models.Follow;
import com.intuit.demo.repositories.FollowRepository;
import com.intuit.demo.util.AuthUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

/**
 * Implements {@link FollowDAO} for modifying {@link Follow} entity.
 * @author Urvashi Heda
 */
@Service
public class DemoFollowDAO implements FollowDAO {

    @Autowired
    private FollowRepository followRepository;

    /**
     * Follow a user.
     * @param followeeUserName username of the followee
     * @return {@link Follow} entity
     */
    @Override
    public Follow startFollowing(String followeeUserName) {
        String loggedInUser = AuthUtils.getLoggedInUserName();
        Follow record = followRepository.findByUsername(loggedInUser);

        if (record == null) {
            Set<String> followees = new HashSet<>();
            followees.add(followeeUserName);
            Follow follow = new Follow(ObjectId.get(), loggedInUser, followees);
            return followRepository.save(follow);
        } else {
            Set<String> followees = record.getFollowees();
            if (followees.contains(followeeUserName)) {
                throw new FollowNotAllowedException("User is already followed");
            } else {
                followees.add(followeeUserName);
                return followRepository.save(record);
            }
        }
    }

    /**
     * Retrieves a set of users followed by logged in user.
     * @return set of users followed
     */
    @Override
    public Set<String> getUsersIAmFollowing() {
        Follow record = followRepository.findByUsername(AuthUtils.getLoggedInUserName());
        if (record != null) {
            return record.getFollowees();
        } else {
            return null;
        }
    }

    /**
     * Un follow a user.
     * @param followeeUserName username of the followee
     * @throws IncorrectRequestException if user to unfollow is never followed or no users are followed
     */
    @Override
    public void unfollow(String followeeUserName) {
        Follow record = followRepository.findByUsername(AuthUtils.getLoggedInUserName());

        if (record != null) {
            Set<String> followees = record.getFollowees();
            if (followees.contains(followeeUserName)) {
                followees.remove(followeeUserName);
                followRepository.save(record);
            } else {
                throw new IncorrectRequestException("User "+ followeeUserName +" is not followed");
            }
        } else {
            throw new IncorrectRequestException("No users followed");
        }
    }
}
