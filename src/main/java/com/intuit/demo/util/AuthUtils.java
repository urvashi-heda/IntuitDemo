package com.intuit.demo.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Authorizes a user
 * @author Urvashi Heda
 */
public class AuthUtils {
    /**
     * Authenticates a user.
     * @return user's name if logged in successfully, otherwise return empty string.
     */
    public static String getLoggedInUserName() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)
                        SecurityContextHolder.getContext().getAuthentication();

        return authentication != null ? authentication.getName() : Constants.EMPTY_STRING;
    }
}
