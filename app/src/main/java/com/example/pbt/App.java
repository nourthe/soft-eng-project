package com.example.pbt;

import android.app.Application;

import com.example.pbt.model.DaoMaster;
import com.example.pbt.model.DaoSession;
import com.example.pbt.persistence.DbOpenHelper;

public class App extends Application {


    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(new DbOpenHelper(this,"PBT.db").getWritableDb()).newSession();
    }


    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
