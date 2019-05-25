package com.example.pbt.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class Like {

    @Id(autoincrement = true)
    Long id;

    @ToOne(joinProperty = "ownerId")
    User owner;
    Long ownerId;

    Long postId;
    Long commentId;
    Long userId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1401850954)
    private transient LikeDao myDao;
    @Generated(hash = 1040002949)
    public Like(Long id, Long ownerId, Long postId, Long commentId, Long userId) {
        this.id = id;
        this.ownerId = ownerId;
        this.postId = postId;
        this.commentId = commentId;
        this.userId = userId;
    }
    @Generated(hash = 763251169)
    public Like() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOwnerId() {
        return this.ownerId;
    }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    public Long getPostId() {
        return this.postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public Long getCommentId() {
        return this.commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Generated(hash = 1847295403)
    private transient Long owner__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 925798786)
    public User getOwner() {
        Long __key = this.ownerId;
        if (owner__resolvedKey == null || !owner__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User ownerNew = targetDao.load(__key);
            synchronized (this) {
                owner = ownerNew;
                owner__resolvedKey = __key;
            }
        }
        return owner;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 819396901)
    public void setOwner(User owner) {
        synchronized (this) {
            this.owner = owner;
            ownerId = owner == null ? null : owner.getId();
            owner__resolvedKey = ownerId;
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
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 935226518)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLikeDao() : null;
    }


}
