package com.example.pbt.data;

import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;
import com.example.pbt.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostData {

    private PBT mPBT;

    private static PostData sPostData;

    private PostData() {mPBT = new PBT();}

    public static synchronized PostData get() {
        if (sPostData == null) sPostData = new PostData();
        return sPostData;
    }

    public void fetchLatestPosts(final int l) {
        // DB
        mPBT.setLatestPostsList(mockDbLatestPosts());
        // Server
        new Thread(new Runnable() {
            @Override
            public void run() {
            try {
                if (mPBT == null) return;
                Thread.sleep(l);

                List<Post> newPostList= new ArrayList<>();
                newPostList.addAll(mPBT.getLatestPostsList().getValue());
                newPostList.addAll(mockServerLatestPosts());
                mPBT.setLatestPostsList(newPostList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }).start();
    }

    private List<Post> mockDbLatestPosts() {
        List<Post> postList=  new ArrayList<>();
        Post post = new Post();
            post.setTitle("DB asdfasdf");
            post.setDescription("DB descipadsfsd");
            post.setDate(new Date());
            User user = new User();
            user.setName("Db user");
            post.setAuthor(user);

        if (Post.isPostValidForPublishing(post)) postList.add(post);
        return postList;
    }
    private List<Post> mockServerLatestPosts() {
        List<Post> postList=  new ArrayList<>();
        Post post = new Post();
            post.setTitle("Server asdfjksadf");
            post.setDescription("Server asfasdf");
            post.setDate(new Date());

            User user = new User();
            user.setName("Server user");
            post.setAuthor(user);
        if (Post.isPostValidForPublishing(post)) postList.add(post);
        return postList;
    }

    public User getMockUser() {
        User u = new User();
        u.setName("Bruno");
        return u;
    }

    public PBT getPBT() {
        return mPBT;
    }
}
