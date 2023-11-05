package com.sparta.spt_noticespjspt.dto;

import java.util.Date;
import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String userName;
    private long password;
    private String contents;
    private Date date;
}
