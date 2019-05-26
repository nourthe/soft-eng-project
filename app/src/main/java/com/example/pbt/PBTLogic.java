package com.example.pbt;

import com.example.pbt.data.PostService;
import com.example.pbt.model.Like;
import com.example.pbt.model.Post;
import com.example.pbt.model.User;

import java.util.List;

public class PBTLogic {

    private List<Post> mRecentPosts;

    private User mCurrentUser;

    public int isPostLikedByUser(Post post, User user) {
       for (Like l : post.getLikes()) {
       }
    }

    public List<Post> getRecentPosts() {
        return mRecentPosts;
    }

    public void setRecentPosts(List<Post> recentPosts) {
        mRecentPosts = recentPosts;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }

    public void setCurrentUser(User currentUser) {
        mCurrentUser = currentUser;
    }
}
