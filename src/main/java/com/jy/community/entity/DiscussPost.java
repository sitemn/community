package com.jy.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussPost {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;   //'0-Normal; 1-Top;
    private int status; //'0-Normal; 1-Featured; 2-Blacklist;'
    private Date createTime;
    private int commentCount;
    private double score;
}
