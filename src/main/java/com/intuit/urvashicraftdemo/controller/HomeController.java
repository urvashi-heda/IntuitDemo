package com.intuit.urvashicraftdemo.controller;

import com.intuit.urvashicraftdemo.util.AuthUtils;
import com.intuit.urvashicraftdemo.util.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<String> index() {
        String loggedInUser = AuthUtils.getLoggedInUserName();
        return new ResponseEntity<>(JsonUtils.createJsonResponse("Welcome  " + loggedInUser), HttpStatus.OK);
    }

    @GetMapping(value="/anonymous", produces="application/json")
    public ResponseEntity<String> openPage() {
        return new ResponseEntity<>(JsonUtils.createJsonResponse("Welcome! This page is open to all"), HttpStatus.OK);
    }
}
