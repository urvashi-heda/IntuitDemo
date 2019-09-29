package com.intuit.urvashicraftdemo.dao;

import com.intuit.urvashicraftdemo.model.Tweet;
import com.intuit.urvashicraftdemo.util.AuthUtils;

import java.util.*;

public class TweetDAO {

    private static TweetDAO tweetDAO = null;

    private static HashMap<String, ArrayList<Tweet>> tweetStore = new HashMap<>();

    public static TweetDAO getInstance() {
        return tweetDAO != null ? tweetDAO : new TweetDAO();
    }

    public void addTweet(Tweet tweet) {
        String loggedInUser = AuthUtils.getLoggedInUserName();
        ArrayList<Tweet> myTweets = tweetStore.getOrDefault(loggedInUser, new ArrayList<>());
        myTweets.add(0, tweet);
        tweetStore.put(loggedInUser, myTweets);
    }

    public ArrayList<Tweet> getAllTweetsForAUser(String user) {
        return tweetStore.getOrDefault(user, new ArrayList<>());
    }

    public HashMap<String, ArrayList<Tweet>> getAllRecords() {
        return tweetStore;
    }
}
