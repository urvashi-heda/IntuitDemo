package com.intuit.demo.models.requestbody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Represents the content of the tweet.
 *
 * @author Urvashi Heda
 */
public class TweetRequestBody {
    @NotEmpty
    @NotNull
    private String content;

    /**
     * Gets the content of the tweet.
     * @return the content of the tweet
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the tweet.
     * @param content the content of the tweet.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
