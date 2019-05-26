package com.example.pbt.model;

import java.util.List;

public abstract class Likeable {

    private List<User> mUserList;


    public void like(User u) {
        mUserList.add(u);
    }

    public long getLikesCount() {
        return mUserList.size();
    }

    public boolean isLikedByUser(User u) {
        for (User user : mUserList) {
            if (user.equals(u)) return true;
        }
        return false;
    }

    public List<User> getLikes() {
        return mUserList;
    }
}
