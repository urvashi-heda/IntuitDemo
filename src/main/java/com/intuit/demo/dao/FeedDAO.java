package com.intuit.demo.dao;

import com.intuit.demo.models.Tweet;
import com.intuit.demo.repositories.TweetRepository;
import com.intuit.demo.util.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implements {@link DemoFeedDAO} interface for modifying {@link Tweet} entity.
 * @author Urvashi Heda
 */
@Service
public class FeedDAO  implements DemoFeedDAO {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    private FollowDAO followDAO;

    /**
     * Retrieves feed for the logged in user.
     * @return list of tweets representing feed
     */
    @Override
    public ArrayList<Tweet> getMyFeed() {
        Set<String> followees = followDAO.getUsersIAmFollowing();
        if (followees == null) {
            followees = new HashSet<>();
        }
        followees.add(AuthUtils.getLoggedInUserName());
        return tweetRepository.findFirst100ByAuthorInOrderByPostDateDesc(followees);
    }
}
