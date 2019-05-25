package com.example.pbt.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import java.util.List;

import org.greenrobot.greendao.DaoException;

@Entity
public class Post {

    @Id(autoincrement = true)
    private Long id;



    @ToOne(joinProperty = "authorId")
    private User author;
    private Long authorId;

    private Date date;
    private String title;
    private String description;

    @ToMany(referencedJoinProperty = "postId")
    private List<Comment> comments;

    @ToMany(referencedJoinProperty = "postId")
    private List<Like> likes;


    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;


    /** Used for active entity operations. */
    @Generated(hash = 572315894)
    private transient PostDao myDao;


    @Generated(hash = 1107320010)
    private transient Long author__resolvedKey;
    


    @Generated(hash = 556758436)
    public Post(Long id, Long authorId, Date date, String title, String description) {
        this.id = id;
        this.authorId = authorId;
        this.date = date;
        this.title = title;
        this.description = description;
    }

    @Generated(hash = 1782702645)
    public Post() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1213812388)
    public List<Comment> getComments() {
        if (comments == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CommentDao targetDao = daoSession.getCommentDao();
            List<Comment> commentsNew = targetDao._queryPost_Comments(id);
            synchronized (this) {
                if (comments == null) {
                    comments = commentsNew;
                }
            }
        }
        return comments;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 249603048)
    public synchronized void resetComments() {
        comments = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1336397126)
    public List<Like> getLikes() {
        if (likes == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LikeDao targetDao = daoSession.getLikeDao();
            List<Like> likesNew = targetDao._queryPost_Likes(id);
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
    @Generated(hash = 1915117241)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPostDao() : null;
    }


}
