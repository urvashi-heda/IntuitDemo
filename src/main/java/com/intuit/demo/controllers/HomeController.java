package com.intuit.demo.controllers;

import com.intuit.demo.util.AuthUtils;
import com.intuit.demo.util.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing login.
 * @author  Urvashi Heda
 */
@RestController
public class HomeController {

    /**
     * Login api for user.
     * @return login response
     */
    @PostMapping(value="/login", produces="application/json")
    public ResponseEntity<String> login() {
        String loggedInUser = AuthUtils.getLoggedInUserName();
        return new ResponseEntity<>(JsonUtils.createJsonResponse("Welcome  " + loggedInUser), HttpStatus.OK);
    }

    /**
     * Api that doesn't require login.
     * @return page content
     */
    @GetMapping (value="/anonymous", produces="application/json")
    public ResponseEntity<String> openPage() {
        return new ResponseEntity<>(JsonUtils.createJsonResponse("Welcome! This page is open to all"), HttpStatus.OK);
    }

    /**
     * Api that only admins can access.
     * @return page content
     */
    @GetMapping (value="/admin", produces="application/json")
    public ResponseEntity<String> openAdminPage() {
        return new ResponseEntity<>(JsonUtils.createJsonResponse("Welcome! This page is open to admins only"), HttpStatus.OK);
    }
}
