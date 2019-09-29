package com.intuit.urvashicraftdemo.controller;

import com.intuit.urvashicraftdemo.dao.FollowDAO;
import com.intuit.urvashicraftdemo.util.AuthUtils;
import com.intuit.urvashicraftdemo.util.TextUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class FollowController {

    FollowDAO followDAO = FollowDAO.getInstance();

    @PostMapping(value="/follow", produces="application/json")
    public ResponseEntity<HashSet<String>> compose(String user) {
        if (TextUtils.isEmpty(user)) {
            throw new NullPointerException("No user provided. Please provide a user name that you want to follow.");
        }

        String loggedInUser = AuthUtils.getLoggedInUserName();
        if (user.equals(loggedInUser)) {
            throw new IllegalArgumentException("You cannot follow yourself");
        }

        followDAO.startFollowing(loggedInUser, user);

        return new ResponseEntity<>(followDAO.getUsersIAmFollowing(), HttpStatus.OK);
    }

    @GetMapping(value="/following", produces = "application/json")
    public ResponseEntity<HashSet<String>> getUsersIAmFollowing(String user) {
        return new ResponseEntity<>(followDAO.getUsersIAmFollowing(), HttpStatus.OK);
    }
}
