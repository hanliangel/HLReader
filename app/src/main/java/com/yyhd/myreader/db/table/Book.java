package com.yyhd.myreader.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by hanli
 * date 2021-03-01.
 * ps:
 */
@Entity
public class Book implements Serializable {


    public static final long serialVersionUID = 1231232L;

    @Id(autoincrement = true)
    public Long bookId;

    /**
     * 书名
     */
    public String bookName;

    /**
     * 书本封面
     */
    public String coverUrl;

    /**
     * 作者
     */
    public String author;

    /**
     * 简介
     */
    public String introduction;

    /**
     * 书本详情的url
     */
    public String bookDetailUrl;

    /**
     * 当前正在读读章节
     */
    @ToOne(joinProperty = "readingChapterUrl")
    public Chapter readingChapter;

    public String readingChapterUrl;

    /**
     * 本书对应的章节
     */
    @ToMany(referencedJoinProperty = "bookId")
    public List<Chapter> chapters;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1097957864)
    private transient BookDao myDao;

    @Generated(hash = 993621563)
    private transient String readingChapter__resolvedKey;


    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Generated(hash = 99492663)
    public Book(Long bookId, String bookName, String coverUrl, String author, String introduction,
            String bookDetailUrl, String readingChapterUrl) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.coverUrl = coverUrl;
        this.author = author;
        this.introduction = introduction;
        this.bookDetailUrl = bookDetailUrl;
        this.readingChapterUrl = readingChapterUrl;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBookDetailUrl() {
        return this.bookDetailUrl;
    }

    public void setBookDetailUrl(String bookDetailUrl) {
        this.bookDetailUrl = bookDetailUrl;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 226386464)
    public List<Chapter> getChapters() {
        if (chapters == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChapterDao targetDao = daoSession.getChapterDao();
            List<Chapter> chaptersNew = targetDao._queryBook_Chapters(bookId);
            synchronized (this) {
                if (chapters == null) {
                    chapters = chaptersNew;
                }
            }
        }
        return chapters;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 936914273)
    public synchronized void resetChapters() {
        chapters = null;
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

    public String getReadingChapterUrl() {
        return this.readingChapterUrl;
    }

    public void setReadingChapterUrl(String readingChapterUrl) {
        this.readingChapterUrl = readingChapterUrl;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 920449393)
    public Chapter getReadingChapter() {
        String __key = this.readingChapterUrl;
        if (readingChapter__resolvedKey == null || readingChapter__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChapterDao targetDao = daoSession.getChapterDao();
            Chapter readingChapterNew = targetDao.load(__key);
            synchronized (this) {
                readingChapter = readingChapterNew;
                readingChapter__resolvedKey = __key;
            }
        }
        return readingChapter;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 829672915)
    public void setReadingChapter(Chapter readingChapter) {
        synchronized (this) {
            this.readingChapter = readingChapter;
            readingChapterUrl = readingChapter == null ? null : readingChapter.getUrl();
            readingChapter__resolvedKey = readingChapterUrl;
        }
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1115456930)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookDao() : null;
    }

}
