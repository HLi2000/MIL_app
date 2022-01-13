package Entities;

import java.io.Serializable;

/**
 * User is used to store all user info
 */

public class User implements Serializable {
    //unhashed
    private String username;
    private String password;
    //hashed
    private int h_username=0;
    private int h_password=0;


    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void hashcode(){
        h_username = username.hashCode() + 1248;
        h_password = password.hashCode() + 1248;
    }

    public int getH_username() {
        return h_username;
    }

    public int getH_password() {
        return h_password;
    }
}