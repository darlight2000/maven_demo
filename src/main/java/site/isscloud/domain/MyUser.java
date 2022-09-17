package site.isscloud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyUser {
    private int id;
    private String username;
    @JsonIgnore
    private String pwd;

    public MyUser(){}

    public MyUser(int id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
