package com.intuit.urvashicraftdemo.dao;

import com.intuit.urvashicraftdemo.util.AuthUtils;
import java.util.HashMap;
import java.util.HashSet;

public class FollowDAO {

    private static FollowDAO followDAO = null;

    private static HashMap<String, HashSet<String>> followStore = new HashMap<>();

    public static FollowDAO getInstance() {
        return followDAO != null ? followDAO : new FollowDAO();
    }

    public void startFollowing(String loggedInUser, String user) {
        HashSet<String> usersIAmFollowing = followStore.getOrDefault(loggedInUser, new HashSet<>());
        usersIAmFollowing.add(user);
        followStore.put(loggedInUser, usersIAmFollowing);
    }

    public HashSet<String> getUsersIAmFollowing() {
        return followStore.getOrDefault(AuthUtils.getLoggedInUserName(), new HashSet<>());
    }
}
