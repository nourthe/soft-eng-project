package com.example.pbt.model;

import java.util.List;

public class Post {

    private String description;

    private List<Comment> mCommentList;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getCommentList() {
        return mCommentList;
    }

    public void setCommentList(List<Comment> commentList) {
        mCommentList = commentList;
    }
}
