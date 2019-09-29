package com.intuit.urvashicraftdemo.dao;

import com.intuit.urvashicraftdemo.model.Tweet;
import com.intuit.urvashicraftdemo.util.AuthUtils;

import java.util.*;

public class FeedDAO {

    private static FeedDAO feedDAO = null;

    TweetDAO tweetDAO = TweetDAO.getInstance();
    FollowDAO followDAO = FollowDAO.getInstance();

    public static FeedDAO getInstance() {
        return feedDAO != null ? feedDAO : new FeedDAO();
    }

    public ArrayList<Tweet> getMyFeed() {
        HashSet<String> usersIAmFollowing = followDAO.getUsersIAmFollowing();

        ArrayList<Tweet> myFeed = new ArrayList<>();

        Iterator<String> usersIAmFollowingItr = usersIAmFollowing.iterator();
        while (usersIAmFollowingItr.hasNext()) {
            myFeed.addAll(tweetDAO.getAllTweetsForAUser(usersIAmFollowingItr.next()));
        }

        // Feed also contains my own tweets
        myFeed.addAll(tweetDAO.getAllTweetsForAUser(AuthUtils.getLoggedInUserName()));

        Collections.sort(myFeed, new TimeComparator());

        return myFeed;
    }

    class TimeComparator implements Comparator<Tweet> {
        public int compare(Tweet t1, Tweet t2) {
            return t2.getPostTime().compareTo(t1.getPostTime());
        }
    }

}
