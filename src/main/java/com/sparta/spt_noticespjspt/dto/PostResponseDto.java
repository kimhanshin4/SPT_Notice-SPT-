package com.sparta.spt_noticespjspt.dto;

import com.sparta.spt_noticespjspt.entity.Post;
import java.util.Date;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String username;
    private long password;
    private String contents;
    private Date date;

    public PostResponseDto(Long id, String title, String userName, long password, String contents,
        Date date) {
        this.id = id;
        this.title = title;
        this.username = userName;
        this.password = password;
        this.contents = contents;
        this.date = date;
    }

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUserName();
        this.password = post.getPassword();
        this.contents = post.getContents();
        this.date = post.getDate();
    }
}
