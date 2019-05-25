package com.example.pbt.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class Comment {

    @Id(autoincrement = true)
    private Long id;

    @ToOne(joinProperty = "authorId")
    private User author;
    private Long authorId;
    private Date date;

    private String title;

    private Long postId;

    @ToMany(referencedJoinProperty = "commentId")
    private List<Like> likes;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1903578761)
    private transient CommentDao myDao;

    @Generated(hash = 2069087792)
    public Comment(Long id, Long authorId, Date date, String title, Long postId) {
        this.id = id;
        this.authorId = authorId;
        this.date = date;
        this.title = title;
        this.postId = postId;
    }

    @Generated(hash = 1669165771)
    public Comment() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(hash = 1107320010)
    private transient Long author__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 251337700)
    public User getAuthor() {
        Long __key = this.authorId;
        if (author__resolvedKey == null || !author__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User authorNew = targetDao.load(__key);
            synchronized (this) {
                author = authorNew;
                author__resolvedKey = __key;
            }
        }
        return author;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1586538657)
    public void setAuthor(User author) {
        synchronized (this) {
            this.author = author;
            authorId = author == null ? null : author.getId();
            author__resolvedKey = authorId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public Long getPostId() {
        return this.postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 166109359)
    public List<Like> getLikes() {
        if (likes == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LikeDao targetDao = daoSession.getLikeDao();
            List<Like> likesNew = targetDao._queryComment_Likes(id);
            synchronized (this) {
                if (likes == null) {
                    likes = likesNew;
                }
            }
        }
        return likes;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 787136169)
    public synchronized void resetLikes() {
        likes = null;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2038262053)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCommentDao() : null;
    }



}
