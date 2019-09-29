package com.intuit.urvashicraftdemo.controller;

import com.intuit.urvashicraftdemo.dao.FeedDAO;
import com.intuit.urvashicraftdemo.dao.FollowDAO;
import com.intuit.urvashicraftdemo.dao.TweetDAO;
import com.intuit.urvashicraftdemo.model.Tweet;
import com.intuit.urvashicraftdemo.util.AuthUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class FeedController {

    FeedDAO feedDAO = FeedDAO.getInstance();
    TweetDAO tweetDAO = TweetDAO.getInstance();

    @GetMapping(value="/feed", produces="application/json")
    public ResponseEntity<ArrayList<Tweet>> getFeed() {
        return new ResponseEntity<>(feedDAO.getMyFeed(), HttpStatus.OK);
    }

    @GetMapping(value="/myTweets", produces="application/json")
    public ResponseEntity<ArrayList<Tweet>> getMyTweets() {
        return new ResponseEntity<>(tweetDAO.getAllTweetsForAUser(AuthUtils.getLoggedInUserName()), HttpStatus.OK);
    }

    @GetMapping(value="/database", produces="application/json")
    public ResponseEntity<HashMap<String, ArrayList<Tweet>>> getAllRecords() {
        return new ResponseEntity<>(tweetDAO.getAllRecords(), HttpStatus.OK);
    }
}
