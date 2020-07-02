package com.sm.service.entity;

import java.util.Date;

public class Article {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getD_abstract() {
        return d_abstract;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user_id=" + user_id +
                ", d_abstract='" + d_abstract + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public void setD_abstract(String d_abstract) {
        this.d_abstract = d_abstract;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    private Integer id;

    private String title;

    private Integer user_id;

    /*name 注解标注数据库中字段名称*/

    private String d_abstract;

    private String content;

    private Integer state;

    private Date create_time;

    private Date update_time;


}
