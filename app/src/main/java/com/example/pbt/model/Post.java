package com.example.pbt.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Post extends Entry {


    private String description;

    private List<Comment> mCommentList;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getCommentList() {
        if (mCommentList == null) mCommentList = new ArrayList<>();
        return mCommentList;
    }

    public void setCommentList(List<Comment> commentList) {
        mCommentList = commentList;
    }

    public static boolean isPostValidForPublishing(Post p) {
        if (p.getAuthor() == null) return false;
        if (p.getAuthor().getName() == null) return false;
        if (p.getAuthor().getName().isEmpty()) return false;
        if (p.getLikes().size() != 0) return false;
        if (p.getCommentList().size() != 0) return false;
        if (p.getTitle().isEmpty()) return false;
        if (p.getDescription().isEmpty()) return false;
        if (p.getDate() == null) return false;

        return true;
    }

    @NonNull
    @Override
    public String toString() {
        return getTitle() + " by " + getAuthor().getName();
    }
}
