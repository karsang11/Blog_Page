package com.example.abcblog.Model;

public class Posts {
    private int imageid;
    private String title;
    private String blog;

    //Constructor


    public Posts(int imageid, String title, String blog) {
        this.imageid = imageid;
        this.title = title;
        this.blog = blog;
    }

    //Getter and setter

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
