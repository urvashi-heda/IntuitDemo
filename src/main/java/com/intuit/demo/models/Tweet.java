package com.intuit.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Representing a tweet.
 * @author Urvashi Heda
 */
public class Tweet {
    @Id
    private ObjectId id;
    private String content;
    private String postDate;
    private String author;

    /**
     * Constructor for the class.
     * @param id unique identifier
     * @param content content of the tweet
     * @param postDate post date of the tweet
     * @param author author of the tweet
     */
    public Tweet(ObjectId id, String content, String postDate, String author) {
        this.id = id;
        this.content = content;
        this.postDate = postDate;
        this.author = author;
    }

    /**
     * Gets the unique identifier for mongo repository.
     * @return the unique identifier
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Sets the unique identifier for mongo repository.
     * @param id the unique identifier
     */
    public void setId(ObjectId id){
        this.id = id;
    }

    /**
     * Gets the author of the tweet.
     * @return the author of the tweet
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the tweet.
     * @param author author of the tweet
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the post date of the tweet.
     * @return the postdate of the tweet
     */
    public String getPostDate() {
        return postDate;
    }

    /**
     * Sets the post date of the tweet
     * @param postDate the post date of the tweet.
     */
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    /**
     * Gets the content of the tweet.
     * @return the content of the tweet.
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
