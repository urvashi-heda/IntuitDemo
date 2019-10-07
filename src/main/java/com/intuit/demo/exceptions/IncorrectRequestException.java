package com.intuit.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * An exception to be used for a incorrect request.
 * @author Urvashi Heda
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectRequestException extends RuntimeException {
    private String errorMessage;

    /**
     * Constructor for the class.
     * @param errorMessage the error message
     */
    public IncorrectRequestException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the exception's error message.
     * @return the error message for the exception
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the exception's error message.
     * @param errorMessage the error message for the exception
     */
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
