package com.example.dbtest;

public class User {

    public String studentid;
    public String email;
    public String phone_num;

    public User() {

    }

    public User(String studentid, String email, String phone_num) {
        this.studentid = studentid;
        this.email = email;
        this.phone_num= phone_num;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_num() {
        return phone_num;
    }
}