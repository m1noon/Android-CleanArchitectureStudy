package com.minoon.architecture.study.data.article;

/**
 * Created by a13587 on 15/09/27.
 */
public class Article {
    public String id;

    public String title;

    public String content;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
