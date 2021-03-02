package com.yyhd.myreader.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hanli
 * date 2021-03-01.
 * ps:
 */
@Entity
public class Chapter {

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

    /**
     * 章节名字
     */
    public String name;

    public Long bookId;

    /**
     * 章节内容
     */
    public String content;

    /**
     * 章节url
     */
    public String url;
}
