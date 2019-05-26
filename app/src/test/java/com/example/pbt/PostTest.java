package com.example.pbt;


import com.example.pbt.model.DaoMaster;
import com.example.pbt.model.DaoSession;
import com.example.pbt.model.Post;
import com.example.pbt.model.User;

import org.greenrobot.greendao.database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
public class PostTest {

    private DaoSession mDaoSession;
    private User currentUser;

    @Before
    public void setUp() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(RuntimeEnvironment.application, null);
        Database db = openHelper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();

        createCurrentUser();
    }

    private void createCurrentUser() {
        currentUser = new User();
        currentUser.setName("Juan");

        mDaoSession.insert(currentUser);
    }

    @Test
    public void createBasicPostWithNoComments_hasNoComments() {
        Post post = new Post();

        post.setAuthorId(currentUser.getId());
        post.setDate(new Date());
        post.setTitle("Hola este es mi primer post");
        post.setDescription("Descrpicion de mi post");

        assertEquals(getCommentsCount, 0);

    }
}
