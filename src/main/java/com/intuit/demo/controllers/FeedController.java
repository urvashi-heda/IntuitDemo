package com.intuit.demo.controllers;

import com.intuit.demo.dao.FeedDAO;
import com.intuit.demo.models.Tweet;
import com.intuit.demo.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

/**
 * REST controller for managing feed.
 * @author  Urvashi Heda
 */
@RestController
public class FeedController {

    @Autowired
    private FeedDAO feedDAO;

    /**
     * Api for getting the feed for a user.
     * @return returns a list of tweets with a status 200 or with a status 204 if no tweets exist
     * @throws Exception
     */
    @GetMapping(value="/feed", produces="application/json")
    public ResponseEntity<ArrayList<Tweet>> getFeed() throws Exception {
        try {
            ArrayList<Tweet> listOfTweets = feedDAO.getMyFeed();
            if (!ListUtils.isEmpty(listOfTweets)) {
                return new ResponseEntity<>(listOfTweets, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
