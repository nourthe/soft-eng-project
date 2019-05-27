package com.example.pbt.model;

import java.util.List;

public class PBT {

    List<Post> mLatestPostsList;





    public List<Post> getLatestPostsList() {
        return mLatestPostsList;
    }

    public void setLatestPostsList(List<Post> latestPostsList) {
        mLatestPostsList = latestPostsList;
    }

    public int getPostsCount() {
        return mLatestPostsList.size();
    }
}
