package com.intuit.demo.dao;

import com.intuit.demo.models.Follow;
import java.util.Set;

/**
 * Interface to modify {@link Follow} entity.
 * @author Urvashi Heda
 */
public interface DemoFollowDAO {
    public Follow startFollowing(String followeeUserName);
    public Set<String> getUsersIAmFollowing();
    public void unfollow(String followeeUserName);
}
