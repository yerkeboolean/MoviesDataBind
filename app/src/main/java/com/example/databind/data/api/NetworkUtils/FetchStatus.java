package com.example.databind.data.api.NetworkUtils;

public class FetchStatus {
    private boolean isOnLoading;
    private boolean isOnSuccess;
    private boolean isOnError;
    private boolean isLast;

    public FetchStatus() {
    }

    public FetchStatus(boolean isOnLoading, boolean isOnSuccess, boolean isOnError, boolean isLast) {
        this.isOnLoading = isOnLoading;
        this.isOnSuccess = isOnSuccess;
        this.isOnError = isOnError;
        this.isLast = isLast;
    }

    public boolean isOnLoading() {
        return isOnLoading;
    }

    public void setOnLoading(boolean onLoading) {
        isOnLoading = onLoading;
    }

    public boolean isOnSuccess() {
        return isOnSuccess;
    }

    public void setOnSuccess(boolean onSuccess) {
        isOnSuccess = onSuccess;
    }

    public boolean isOnError() {
        return isOnError;
    }

    public void setOnError(boolean onError) {
        isOnError = onError;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}
