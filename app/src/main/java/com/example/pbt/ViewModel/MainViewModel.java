package com.example.pbt.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.pbt.data.PostData;
import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;

import java.util.List;
import java.util.Objects;

public class MainViewModel extends ViewModel {
    private PostData mPostData;
    private PBT mPBT;

    public MainViewModel() {
        mPostData = PostData.get();
        mPBT = mPostData.getPBT();
    }

    public LiveData<List<Post>> getRecentPosts() {
        mPostData.fetchLatestPosts(1000);
        mPostData.fetchLatestPosts(3000);
        mPostData.fetchLatestPosts(5000);
        return mPBT.getLatestPostsList();
    }

    @SuppressWarnings("ConstantConditions")
    public Post getPost(int i) {
        return mPBT.getLatestPostsList().getValue().get(i);
    }


}
