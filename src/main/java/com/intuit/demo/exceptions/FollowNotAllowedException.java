package com.intuit.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A custom exception to be used when a user makes an unacceptable follow request.
 * @author Urvashi Heda
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class FollowNotAllowedException extends RuntimeException {
    private String errorMessage;

    /**
     * Constructor for the class.
     * @param errorMessage the error message
     */
    public FollowNotAllowedException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the exception's error message.
     * @return the error message of the exception
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the exception's error message.
     * @param errorMessage the error message of the exception
     */
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
