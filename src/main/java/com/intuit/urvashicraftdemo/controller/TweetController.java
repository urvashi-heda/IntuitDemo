package com.intuit.urvashicraftdemo.controller;

import com.intuit.urvashicraftdemo.model.Tweet;
import com.intuit.urvashicraftdemo.dao.TweetDAO;
import com.intuit.urvashicraftdemo.util.AuthUtils;
import com.intuit.urvashicraftdemo.util.TextUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetController {

    TweetDAO tweetDAO = TweetDAO.getInstance();

    @PostMapping(value="/tweet", produces="application/json")
    public ResponseEntity<Tweet> tweet(String content) {
        if (TextUtils.isEmpty(content)) {
            throw new NullPointerException("This is an empty post. Please add some content");

        }
        Tweet tweet = new Tweet(content, AuthUtils.getLoggedInUserName());
        tweetDAO.addTweet(tweet);
        return new ResponseEntity<>(tweet, HttpStatus.OK);
    }
}
