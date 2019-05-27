package com.example.pbt.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.pbt.data.PostData;
import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;

import java.util.List;

public class MainViewModel extends ViewModel {
    private PBT mPBT;
    private PostData mPostData;

    public MainViewModel() {
        mPBT = new PBT();
        mPostData = new PostData(mPBT);
    }

    public LiveData<List<Post>> getRecentPosts() {
        mPostData.fetchLatestPosts(1000);
        mPostData.fetchLatestPosts(3000);
        mPostData.fetchLatestPosts(5000);
        return mPBT.getLatestPostsList();
    }

}
