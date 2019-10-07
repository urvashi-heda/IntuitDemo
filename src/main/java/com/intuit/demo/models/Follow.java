package com.intuit.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * Represents a user and a set of users it follows.
 * @author Urvashi Heda
 */
public class Follow {

    @Id
    private ObjectId id;
    private String username;
    private Set<String> followees;

    /**
     * Constructor for the class.
     * @param id unique identifier
     * @param username username of the logged in user
     * @param followees set of username of followees
     */
    public Follow(ObjectId id, String username, Set<String> followees) {
        this.id = id;
        this.username = username;
        this.followees = followees;
    }

    /**
     * Gets the unique identifier for mongo repository.
     * @return the
     */
    public ObjectId getId(){
        return id;
    }

    /**
     * Sets the unique identifier for mongo repository.
     * @param id the unique identifier
     */
    public void setId(ObjectId id){
        this.id = id;
    }

    /**
     * Gets the username of logged in user.
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the logged in user.
     * @param username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the set of username of the followees.
     * @return set of username of the followees
     */
    public Set<String> getFollowees() {
        return followees;
    }

    /**
     * Sets the set of username of the followees.
     * @param followees set of username of the follwees
     */
    public void setFollowees(Set<String> followees) {
        this.followees = followees;
    }
}
