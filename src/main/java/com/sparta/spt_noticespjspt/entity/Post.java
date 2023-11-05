package com.sparta.spt_noticespjspt.entity;

import com.sparta.spt_noticespjspt.dto.PostRequestDto;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Post {
    private Long id; //post끼리 구분을 위함
    private String title;
    private String userName;
    private long password;
    private String contents;
    private Date date;

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.userName = requestDto.getUserName();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
        this.date = requestDto.getDate();
    }
}
