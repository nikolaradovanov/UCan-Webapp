package com.ovdebeli.ucan.models;

public class UserPreferences {

    Long userPreferencesId;
    Long quoteId;
    Long userId;

    public UserPreferences() {
    }

    public UserPreferences(Long userPreferencesId, Long quoteId, Long userId) {
        this.userPreferencesId = userPreferencesId;
        this.quoteId = quoteId;
        this.userId = userId;
    }

    public Long getUserPreferencesId() {
        return userPreferencesId;
    }

    public void setUserPreferencesId(Long userPreferencesId) {
        this.userPreferencesId = userPreferencesId;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
