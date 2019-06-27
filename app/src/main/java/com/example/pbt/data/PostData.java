package com.example.pbt.data;

import com.example.pbt.model.Comment;
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
            post.setTitle("Córdoba desde el Coral State viendo hacia las sierras [OC] ");
            post.setDescription("DB descipadsfsd");
            post.setDate(new Date());
            User user = new User();
            user.setName("Db user");
            post.setAuthor(user);

        Post post2 = new Post();
        post2.setTitle("Cortaste toda la loz");
        post2.setDescription("DB 2");
        post2.setDate(new Date());
        User user2 = new User();
        user2.setName("Db user 2");
        post2.setAuthor(user2);

        Post post3 = new Post();
        post3.setTitle("Que onda esto gente? Se viene Buenos Aires 2077?");
        post3.setDescription("DB 3");
        post3.setDate(new Date());
        User user3 = new User();
        user3.setName("Db user 3");
        post3.setAuthor(user3);

        post3.setDate(new Date());
        post2.setDate(new Date());
        post.setDate(new Date());

        if (Post.isPostValidForPublishing(post)) postList.add(post);
        if (Post.isPostValidForPublishing(post2)) postList.add(post2);
        if (Post.isPostValidForPublishing(post3)) postList.add(post3);
        return postList;
    }
    private List<Post> mockServerLatestPosts() {
        List<Post> postList=  new ArrayList<>();
        Post post = new Post();
            post.setTitle("El Concejo de La Plata reconoció al \"Batman Solidario\" por su ayuda a la comunidad");
            post.setDescription("Server asfasdf");
            post.setDate(new Date());

            User user = new User();
            user.setName("Server user");
            post.setAuthor(user);
            List<Comment> commentList = new ArrayList<>();
            Comment c1 = new Comment();
            c1.setAuthor(new User("Julian"));
            c1.setTitle("Muy buen post");
            Comment c2 = new Comment();
            c2.setAuthor(new User("Bruno"));
            c2.setTitle("No se entiende el post");
            commentList.add(c1);
            commentList.add(c2);
            post.setCommentList(commentList);
        if (Post.isPostValidForPublishing(post)) postList.add(post);


        Post post2 = new Post();
        post2.setTitle("La carne argentina llegó a los supermercados de Japón a 100 dólares el kilo");
        post2.setDescription("Server asfasdf");

        post2.setDate(new Date());

        User user2 = new User();
        user2.setName("Server user");
        post2.setAuthor(user2);
        if (Post.isPostValidForPublishing(post2)) postList.add(post2);

        Post post3 = new Post();
        post3.setTitle("En la Argentina hay 14 millones de vehículos (y sólo 40 son eléctricos)");
        post3.setDescription("Server asfasdf");
        post3.setDate(new Date());

        User user3 = new User();
        user3.setName("Server user");
        post3.setAuthor(user3);

        post2.setDate(new Date());
        post.setDate(new Date());
        post3.setDate(new Date());
        if (Post.isPostValidForPublishing(post3)) postList.add(post3);
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
