package com.intuit.demo.dao;

import com.intuit.demo.models.Tweet;
import com.intuit.demo.repositories.TweetRepository;
import com.intuit.demo.util.AuthUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Implements {@link DemoTweetDAO} interface for modifying {@link Tweet} entity.
 * @author Urvashi Heda
 */
@Service
public class TweetDAO  implements DemoTweetDAO {

    @Autowired
    private TweetRepository tweetRepository;

    /**
     * Posts a tweet for the logged in user
     * @param content content of the tweet
     * @return {@link Tweet} entity
     */
    @Override
    public Tweet postTweet(String content) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Tweet tweet = new Tweet(ObjectId.get(), content, dateFormat.format(date), AuthUtils.getLoggedInUserName());

        return tweetRepository.save(tweet);
    }

    /**
     * Retrieves a list of tweets for logged in user.
     * @param user username of logged in user
     * @return list of tweets
     */
    @Override
    public ArrayList<Tweet> getAllTweetsForUser(String user) {
        return tweetRepository.findByAuthorOrderByPostDateDesc(user);
    }
}
