package com.db.articledirect.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="article_details")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userId",nullable = false)
    private long userId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "date",nullable = false)
    private String date;

    @Column(name = "status",nullable = false)
    private String status;

    public Article(){}
    public Article(long userId, String name, String content, String date, String status) {
        this.userId = userId;
        this.name = name;
        this.content = content;
        this.date = date;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
