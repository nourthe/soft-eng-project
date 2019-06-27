package com.example.pbt.model;

import android.support.annotation.NonNull;

public class Comment extends Entry{
    @NonNull
    @Override
    public String toString() {
        return getTitle() + " by " + getAuthor().getName();
    }
}
