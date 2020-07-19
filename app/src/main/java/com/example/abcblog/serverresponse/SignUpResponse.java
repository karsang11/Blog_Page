package com.example.abcblog.serverresponse;

public class SignUpResponse {
    private String _id;
    private String status;
    private String token;
    private Boolean admin;

    public SignUpResponse(String _id, String status, String token,Boolean admin) {
        this._id = _id;
        this.status = status;
        this.token = token;
        this.admin=admin;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
