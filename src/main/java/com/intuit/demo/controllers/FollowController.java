package com.intuit.demo.controllers;

import com.intuit.demo.dao.FollowDAO;
import com.intuit.demo.exceptions.IncorrectRequestException;
import com.intuit.demo.exceptions.FollowNotAllowedException;
import com.intuit.demo.models.Follow;
import com.intuit.demo.models.requestbody.FollowRequestBody;
import com.intuit.demo.util.AuthUtils;
import com.intuit.demo.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

/**
 * REST controller for managing follow.
 * @author  Urvashi Heda
 */
@RestController
public class FollowController {

    @Autowired
    private FollowDAO followDAO;

    /**
     * Api for following a user.
     * @param followRequestBody json request body for follow
     * @param bindingResult
     * @return successfully added followees
     * @throws Exception
     */
    @PutMapping(value="/follow", produces="application/json")
    public ResponseEntity<Follow> follow(@RequestBody @Valid FollowRequestBody followRequestBody, BindingResult bindingResult) throws
            Exception  {
        if (bindingResult.hasFieldErrors("followingName")) {
            throw new IncorrectRequestException("following name field is missing or it's value is empty");
        }

        if (followRequestBody.getFolloweeUserName().equals(AuthUtils.getLoggedInUserName())) {
            throw new FollowNotAllowedException("You cannot follow yourself");
        }

        try {
            Follow follow = followDAO.startFollowing(followRequestBody.getFolloweeUserName());
            return new ResponseEntity<>(follow, HttpStatus.OK);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    /**
     * Api for getting all followees.
     * @return returns a set of followees with a status 200 or with a status 204 if no followees exist
     * @throws Exception
     */
    @GetMapping(value="/followees", produces = "application/json")
    public ResponseEntity<Set<String>> getUsersIAmFollowing() throws Exception {
        try {
            Set<String> followees = followDAO.getUsersIAmFollowing();
            if(!ListUtils.isEmpty(followees)) {
                return new ResponseEntity<>(followees, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    /**
     * Api for un following a user.
     * @param followRequestBody json request body for un follow
     * @param bindingResult
     * @return list of remaining followees
     * @throws Exception
     */
    @PutMapping(value="/unfollow", produces = "application/json")
    public ResponseEntity<Set<String>> unfollow(@RequestBody @Valid FollowRequestBody followRequestBody, BindingResult bindingResult) throws Exception {
        try {
            if (bindingResult.hasFieldErrors("followeeUserName")) {
                throw new IncorrectRequestException("followee user name field is missing or it's value is empty");
            }
            followDAO.unfollow(followRequestBody.getFolloweeUserName());
            return new ResponseEntity<>(followDAO.getUsersIAmFollowing(), HttpStatus.OK);
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
