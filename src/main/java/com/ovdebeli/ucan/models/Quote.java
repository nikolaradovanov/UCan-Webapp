package com.ovdebeli.ucan.models;

public class Quote {

    Long quoteId;
    String quoteText;
    Long authorId;
    Long categoryId;

    public Quote() {
    }

    public Quote(Long quoteId, String quoteText, Long authorId, Long categoryId) {
        this.quoteId = quoteId;
        this.quoteText = quoteText;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
