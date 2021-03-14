package com.yyhd.myreader.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.DaoException;

/**
 * Created by hanli
 * date 2021-03-01.
 * ps:
 */
@Entity
public class Chapter implements Serializable {

    public static final long serialVersionUID = 1231332L;

    /**
     * 章节名字
     */
    public String name;

    /**
     * 所属的书本id
     */
    public Long bookId;

    /**
     * 章节内容
     */
    public String content;


    /**
     * 章节url
     */
    @Id
    public String url;

    public Chapter(String name) {
        this.name = name;
    }

    @Generated(hash = 1216730487)
    public Chapter(String name, Long bookId, String content, String url) {
        this.name = name;
        this.bookId = bookId;
        this.content = content;
        this.url = url;
    }

    @Generated(hash = 393170288)
    public Chapter() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
