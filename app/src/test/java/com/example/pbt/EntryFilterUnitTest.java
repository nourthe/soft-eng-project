package com.example.pbt;

import com.example.pbt.model.Post;
import com.example.pbt.model.User;
import com.example.pbt.util.sort.EntryAuthorEntrySort;
import com.example.pbt.util.sort.EntryDateEntrySort;
import com.example.pbt.util.sort.EntryTitleEntrySort;
import com.example.pbt.util.sort.EntryFilter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EntryFilterUnitTest {

    private List<Post> posts;
    private List<User> users;
    private EntryFilter entryFilter;

    @Before
    public void setUp(){
        posts = new ArrayList<>();
        users = new ArrayList<>();
        generateUsers();
        generatePosts(users);
    }

    /**
     * Simple sorting
     */
    @Test
    public void entryAuthorSort_sortPostByAuthor_equalsToOriginal() {
        entryFilter = new EntryAuthorEntrySort();

        List<Post> sList = entryFilter.filter(posts);
        List<Post> cList = new ArrayList<>();
        cList.add(posts.get(0));
        cList.add(posts.get(3));
        cList.add(posts.get(6));
        cList.add(posts.get(9));
        cList.add(posts.get(1));
        cList.add(posts.get(4));
        cList.add(posts.get(7));
        cList.add(posts.get(10));
        cList.add(posts.get(2));
        cList.add(posts.get(5));
        cList.add(posts.get(8));
        cList.add(posts.get(11));

        assertThat(sList.equals(cList), is(true));
    }

    /**
     * Simple negative reverse sorting
     */
    @Test
    public void entryAuthorSort_sortAndReversePostByAuthor_differsOriginal() {
        entryFilter = new EntryAuthorEntrySort();

        List<Post> sList = entryFilter.filter(posts);
        Collections.reverse(sList);

        assertThat(sList.equals(posts), is(false));
    }

    /**
     * Sorting with nulls values
     */
    @Test
    public void entryAuthorSort_sortPostByAuthorWithNulls_notCrash() {
        entryFilter = new EntryAuthorEntrySort();
        posts.get(3).getAuthor().setName(null);

        List<Post> sList = entryFilter.filter(posts);

        assertThat(sList.get(11).equals(posts.get(9)), is(true));
    }

    /**
     * Simple sorting
     */
    @Test
    public void entryTitleSort_sortPostByTitle_equalsToOriginal() {
        entryFilter = new EntryTitleEntrySort();

        List<Post> sList = entryFilter.filter(posts);
        List<Post> cList = new ArrayList<>();
        cList.add(posts.get(0));
        cList.add(posts.get(1));
        cList.add(posts.get(10));
        cList.add(posts.get(11));
        cList.add(posts.get(2));
        cList.add(posts.get(3));
        cList.add(posts.get(4));
        cList.add(posts.get(5));
        cList.add(posts.get(6));
        cList.add(posts.get(7));
        cList.add(posts.get(8));
        cList.add(posts.get(9));

        assertThat(sList.equals(cList), is(true));
    }

    /**
     * Simple negative reverse sorting
     */
    @Test
    public void entryTitleSort_sortAndReversePostByTitle_differsOriginal() {
        entryFilter = new EntryAuthorEntrySort();

        List<Post> sList = entryFilter.filter(posts);
        Collections.reverse(sList);

        assertThat(sList.equals(posts), is(false));
    }

    /**
     * Sorting with nulls values
     */
    @Test
    public void entryTitleSort_sortPostByTitleWithNulls_notCrash() {
        entryFilter = new EntryTitleEntrySort();
        posts.get(3).setTitle(null);

        List<Post> sList = entryFilter.filter(posts);

        assertThat(sList.get(11).equals(posts.get(3)), is(true));
    }

    /**
     * Simple sorting
     */
    @Test
    public void entryDateSort_sortPostByDate_equalsToOriginal() {
        entryFilter = new EntryDateEntrySort();

        List<Post> sList = entryFilter.filter(posts);
        Collections.reverse(posts);

        assertThat(sList.equals(posts), is(true));
    }

    /**
     * Simple negative reverse sorting
     */
    @Test
    public void entryDateSort_sortAndReversePostByDate_differsOriginal() {
        entryFilter = new EntryDateEntrySort();

        List<Post> sList = entryFilter.filter(posts);

        assertThat(sList.equals(posts), is(false));
    }

    /**
     * Sorting with nulls values
     */
    @Test
    public void entryDateSort_sortPostByDateWithNulls_notCrash() {
        entryFilter = new EntryDateEntrySort();
        posts.get(3).setDate(null);

        List<Post> sList = entryFilter.filter(posts);

        assertThat(sList.get(11).equals(posts.get(3)), is(true));
    }

    private void generateUsers() {
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("usuario "+i);
            users.add(user);
        }
    }

    private void generatePosts(List<User> userList) {
        for (int i = 0; i < 12 ; i++) {
            Post post = new Post();
            post.setAuthor(userList.get(i%3));
            post.setTitle("Post number "+i);
            post.setDescription("A very large and interesting description.");
            post.setDate( getDateBeforeToday(i) );
            posts.add(post);
        }
    }

    private Date getDateBeforeToday(int days){
        return new Date(System.currentTimeMillis() - days * 24*60*60*1000);
    }
}