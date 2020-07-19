package com.example.abcblog.Model;

public class Posts {
    private int imageid;
    private String title;
    private String blog;
    private String _id;
    //Constructor


    public Posts(String title,String blog)
    {
        this.title=title;
        this.blog=blog;
    }
    public Posts(int imageid, String title, String blog) {
        this.imageid = imageid;
        this.title = title;
        this.blog = blog;
    }

    public Posts(String _id) {
        this._id = _id;
    }

//Getter and setter


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

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
