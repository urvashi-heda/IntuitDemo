package com.intuit.demo.dao;

import com.intuit.demo.models.Tweet;

import java.util.ArrayList;

/**
 * Interface to modify {@link Tweet} entity.
 * @author Urvashi Heda
 */
public interface DemoTweetDAO {
    public Tweet postTweet(String content);
    public ArrayList<Tweet> getAllTweetsForUser(String user);
}
