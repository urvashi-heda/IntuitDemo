package com.intuit.urvashicraftdemo.model;

import java.util.HashSet;

public class User {

    private String name;

    private HashSet<String> following;  // Users current signed in user is following

    public User(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getFollowing() {
        return following;
    }

    public void setFollowing(HashSet<String> following) {
        this.following = following;
    }
}
