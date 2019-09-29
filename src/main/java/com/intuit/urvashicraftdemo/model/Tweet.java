package com.intuit.urvashicraftdemo.model;

public class Tweet {

    private String content;

    private Long postTime;

    private User author;

    public Tweet(String content, String author) {
        setContent(content);
        setAuthor(new User(author));
        setPostTime(System.currentTimeMillis());
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getPostTime() {
        return postTime;
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
