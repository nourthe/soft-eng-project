package com.example.pbt.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.pbt.data.PostData;
import com.example.pbt.data.UserData;
import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;
import com.example.pbt.model.User;

import java.util.List;
import java.util.Objects;

public class MainViewModel extends ViewModel {
    private PBT mPBT;
    private PostData mPostData;
    private UserData mUserData;

    public MainViewModel() {
        mPostData = PostData.get();
        mPBT = mPostData.getPBT();
        mUserData = UserData.get();
        mPBT.setCurrentUser(mPostData.getMockUser());
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

    public boolean isPostLiked(Post post) {
        return post.isLikedByUser(mPBT.getCurrentUser());
    }

    public void likePost(Post post) {
        post.like(mPBT.getCurrentUser());
    }
}
