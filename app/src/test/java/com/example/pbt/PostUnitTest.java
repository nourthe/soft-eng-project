package com.example.pbt;


import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;
import com.example.pbt.model.User;

import static com.example.pbt.model.Post.isPostValidForPublishing;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostUnitTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private PBT pbt;


    @Before
    public void setUp() {
        pbt = new PBT();
    }


    @Test
    public void posts_createEmptyList_postSize0() {
        List<Post> postsList = new ArrayList<>();
        pbt.setLatestPostsList(postsList);
        assertThat(pbt.getPostsCount(), is(0));
    }

    @Test
    public void posts_createNonEmptyList_postSize5() {
        List<Post> postsList = generatePostWithOnlyTitleAndDescription();
        pbt.setLatestPostsList(postsList);
        assertThat(pbt.getPostsCount(), is(3));
    }

    @Test
    public void post_createInvalidPosts_postInvalid() {
        List<Post> postsList = generatePostWithOnlyTitleAndDescription();

        for (Post p :  postsList) {
            assertThat(isPostValidForPublishing(p), is(false));
        }
    }
    @Test
    public void post_createPostWithUserWithEmptyName_postInvalid() {
        Post post = generatePostWithUserButNoName();
        assertThat(isPostValidForPublishing(post), is(false));
    }
    @Test
    public void post_createPostWithUserWithNullName_postInvalid() {
        Post post = generatePostWithUserButNullName();
        assertThat(isPostValidForPublishing(post), is(false));
    }


    @Test
    public void post_createValidPosts_postValid() {
        Post post;
        post = generateValidPost();

        assertThat(isPostValidForPublishing(post), is(true));
    }




    @Test
    public void like_userLikePost_postLiked() {
        Post post = generateValidPost();
        User user = new User();
        post.like(user);
        assertThat(post.isLikedByUser(user), is(true));
    }

    @Test
    public void like_otherUserlikePost_postNotLiked() {
        Post post = generateValidPost();
        User user = new User();
        post.like(user);
        assertThat(post.isLikedByUser(new User()), is(false));
    }


    @Test
    public void like_postHasNoLikes_likeCounterEq0() {
        Post post = generateValidPost();
        assertThat(post.getLikesCount(), is(0L));
    }

    @Test
    public void like_userLikeTwice_likeCounterNotIncremented() {
        Post post = generateValidPost();
        User user = new User();
        post.like(user);
        post.like(user);
        assertThat(post.getLikesCount(), is(1L));
    }


    private List<Post> generatePostWithOnlyTitleAndDescription() {
        List<Post> postsList = new ArrayList<>();
        Post post1 = new Post();
        post1.setTitle("Titulo de post 1");
        post1.setDescription("Descripcion de post 1");
        Post post2 = new Post();
        post2.setTitle("Titulo de post 2");
        post2.setDescription("Descripcion de post 2");

        Post post3 = new Post();
        post3.setTitle("Titulo de post 3");
        post3.setDescription("Descripcion de post 3");

        postsList.add(post1);
        postsList.add(post2);
        postsList.add(post3);
        return postsList;
    }

    private Post generatePostWithUserButNoName() {
        Post post;
        post= new Post();

        post.setDescription("aasdfsd");
        post.setTitle("aasdfsd");
        post.setDate(new Date());
        User u = new User();
        post.setAuthor(u);
        post.setDescription("asdfkjsadfklsjd");
        return post;
    }

    private Post generatePostWithUserButNullName() {
        Post post;
        post= new Post();

        post.setDescription("aasdfsd");
        post.setTitle("aasdfsd");
        post.setDate(new Date());
        User u = new User();
        u.setName("");
        post.setAuthor(u);
        post.setDescription("asdfkjsadfklsjd");
        return post;
    }


    private Post generateValidPost() {
        Post post;
        post= new Post();

        post.setDescription("aasdfsd");
        post.setTitle("aasdfsd");
        post.setDate(new Date());
        User u = new User();
        u.setName("example user");
        post.setAuthor(u);
        post.setDescription("asdfkjsadfklsjd");
        return post;
    }


}
