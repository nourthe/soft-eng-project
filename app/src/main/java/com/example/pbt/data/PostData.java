package com.example.pbt.data;

import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;
import com.example.pbt.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostData {

    PBT mPBT;

    public PostData(PBT PBT) {
        mPBT = PBT;
    }

    public void fetchLatestPosts() {
        // DB
        mPBT.setLatestPostsList(mockDbLatestPosts());
        // Server
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (mPBT == null) return;
                mPBT.setLatestPostsList(mockServerLatestPosts());
            }
        });
    }

    private List<Post> mockDbLatestPosts() {
        List<Post> postList=  new ArrayList<>();
        Post post = new Post();
            post.setDescription("DB descipadsfsd");
            post.setTitle("DB asdfasdf");
            post.setDate(new Date());
            post.setAuthor(new User());
        postList.add(post);
        return postList;
    }
    private List<Post> mockServerLatestPosts() {
        List<Post> postList=  new ArrayList<>();
        Post post = new Post();
            post.setDescription("Server asfasdf");
            post.setTitle("Server asdfjksadf");
            post.setDate(new Date());
            post.setAuthor(new User());
        postList.add(post);
        return postList;
    }

}
