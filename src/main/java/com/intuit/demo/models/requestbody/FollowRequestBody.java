package com.intuit.demo.models.requestbody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Represents the username of the followee.
 * @author Urvashi Heda
 */
public class FollowRequestBody {

    @NotEmpty
    @NotNull
    private String followeeUserName;

    /**
     * Gets the username of the followee.
     * @return the username of the followee
     */
    public String getFolloweeUserName() {
        return followeeUserName;
    }

    /**
     * Sets the username of the followee.
     * @param followeeUserName the username of the followee.
     */
    public void setFolloweeUserName(String followeeUserName) {
        this.followeeUserName = followeeUserName;
    }
}
