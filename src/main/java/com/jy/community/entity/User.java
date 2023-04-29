package com.jy.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;    //salt for password encryption
    private String email;
    private int type;   //0-Subscriber; 1-Admin; 2-ForumManager
    private int status; //0-Nonactivated; 1-Activated
    private String activationCode;
    private String headerUrl;   //default header url
    private Date createTime;
}
