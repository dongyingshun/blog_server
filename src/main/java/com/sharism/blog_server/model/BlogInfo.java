package com.sharism.blog_server.model;

public class BlogInfo {
    private String id;

    private String userId;

    private String sort;

    private String blogTitle;

    private Integer remove;

    private String publishDate;

    private Integer draft;

    private Integer transpondAmount;

    private Integer praiseAmount;

    private Integer weight;

    private Integer readCount;

    private Integer privacySet;

    private String blog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Integer getRemove() {
        return remove;
    }

    public void setRemove(Integer remove) {
        this.remove = remove;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate == null ? null : publishDate.trim();
    }

    public Integer getDraft() {
        return draft;
    }

    public void setDraft(Integer draft) {
        this.draft = draft;
    }

    public Integer getTranspondAmount() {
        return transpondAmount;
    }

    public void setTranspondAmount(Integer transpondAmount) {
        this.transpondAmount = transpondAmount;
    }

    public Integer getPraiseAmount() {
        return praiseAmount;
    }

    public void setPraiseAmount(Integer praiseAmount) {
        this.praiseAmount = praiseAmount;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getPrivacySet() {
        return privacySet;
    }

    public void setPrivacySet(Integer privacySet) {
        this.privacySet = privacySet;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog == null ? null : blog.trim();
    }
}