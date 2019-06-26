package com.example.pbt.data;

import com.example.pbt.model.PBT;
import com.example.pbt.model.User;

public class UserData {
    private static UserData sUserData;

    private UserData() {}

    public static synchronized UserData get() {
        if (sUserData == null) sUserData = new UserData();
        return sUserData;
    }

    public boolean loginUser(User user) {
        return true;
    }

}
