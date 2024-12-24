/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.model;

/**
 *
 * @author admin!
 */
public class User {
    private String username;
    private String password;
    private String full_name;
    private String email;
  public static String name = "";
    // Constructor mặc định
    public User() {
    }

    // Constructor với username, password, full_name, email
    public User(String username, String password, String full_name, String email) {
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.email = email;
        
          name = this.username;
    }

    // Constructor với username và password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
         name = this.username;
    }

    // Getter và Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", full_name=" + full_name + ", email=" + email + '}';
    }


}
