package com.intuit.demo.controllers;

import com.intuit.demo.dao.TweetDAO;
import com.intuit.demo.exceptions.FollowNotAllowedException;
import com.intuit.demo.exceptions.IncorrectRequestException;
import com.intuit.demo.models.Tweet;
import com.intuit.demo.models.requestbody.TweetRequestBody;
import com.intuit.demo.util.AuthUtils;
import com.intuit.demo.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * REST controller for managing tweets.
 * @author  Urvashi Heda
 */
@RestController
public class TweetController {

    @Autowired
    private TweetDAO tweetDAO;

    /**
     * Api for posting a tweet.
     * @param tweetRequestBody json request body for a tweet
     * @param bindingResult
     * @return successfully posted tweet
     * @throws Exception
     */
    @PostMapping(value="/tweet", produces="application/json")
    public ResponseEntity<Tweet> tweet(@RequestBody @Valid TweetRequestBody tweetRequestBody, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasFieldErrors("content")) {
            throw new IncorrectRequestException("content field is missing or it's value is empty");
        }
        try {
            Tweet postedTweet = tweetDAO.postTweet(tweetRequestBody.getContent());
            return new ResponseEntity<>(postedTweet, HttpStatus.CREATED);
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    /**
     * Api for getting all the tweets for a user.
     * @return returns a list of tweets with a status 200 or with a status 204 if no tweets exist
     * @throws Exception
     */
    @GetMapping(value="/tweets", produces="application/json")
    public ResponseEntity<ArrayList<Tweet>> getMyTweets() throws Exception {
        try {
            ArrayList<Tweet> listOfTweetsOfUser = tweetDAO.getAllTweetsForUser(AuthUtils.getLoggedInUserName());
            if (!ListUtils.isEmpty(listOfTweetsOfUser)) {
                return new ResponseEntity<>(listOfTweetsOfUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
