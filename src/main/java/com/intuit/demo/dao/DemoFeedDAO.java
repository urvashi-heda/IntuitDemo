package com.intuit.demo.dao;

import com.intuit.demo.models.Tweet;

import java.util.ArrayList;

/**
 * Interface to modify {@link Tweet} entity.
 * @author Urvashi Heda
 */
public interface DemoFeedDAO {
    public ArrayList<Tweet> getMyFeed();
}
