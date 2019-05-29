package com.example.pbt.model;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class PBT {

    private MutableLiveData<List<Post>> mLatestPostsList;

    public PBT() {
        mLatestPostsList = new MutableLiveData<>();
        mLatestPostsList.setValue(new ArrayList<Post>());
    }

    public MutableLiveData<List<Post>> getLatestPostsList() {
        return mLatestPostsList;
    }




    public void setLatestPostsList(List<Post> latestPostsList) {
        mLatestPostsList.postValue(latestPostsList);
    }

    public int getPostsCount() {
        return mLatestPostsList.getValue().size();
    }
}
