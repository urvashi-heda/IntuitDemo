package com.intuit.urvashicraftdemo.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {
    public static String getLoggedInUserName() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)
                        SecurityContextHolder.getContext().getAuthentication();

        return authentication != null ? authentication.getName() : Constants.EMPTY_STRING;
    }
}
