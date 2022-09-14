package com.example.jeong_repository.model;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CommunityModel {

    private int uid;
    private String title;
    private String content;
    private String save_time;

}
