package com.example.model.review;

public class ReviewDto {

    private Long id;
    private String username;
    private String review;

    public ReviewDto(Long id, String username, String review) {
        this.id = id;
        this.username = username;
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
