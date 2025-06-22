package com.bazar.bazarbooks.dto;

public class BookInput {
    private String title;
    private String imageUrl;
    private String description;
    private String price;
    private double rating;
    private int reviewCount;
    private String store;

    public BookInput() {}

    public BookInput(String title, String imageUrl, String description, String price,
                     double rating, int reviewCount, String store) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.store = store;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public int getReviewCount() {
        return reviewCount;
    }
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
    public String getStore() {
        return store;
    }
    public void setStore(String store) {
        this.store = store;
    }
}
