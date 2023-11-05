package com.sparta.spt_noticespjspt.controller;

import com.sparta.spt_noticespjspt.dto.PostRequestDto;
import com.sparta.spt_noticespjspt.dto.PostResponseDto;
import com.sparta.spt_noticespjspt.entity.Post;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //따로 @ResponseBody 를 달아주지 않아도 해당 기능 자동적용
@RequestMapping("/api")
public class PostController {
    private final Map<Long, Post> postList = new HashMap<>(); //3. HashMap으로 구현체 설정

    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        //1. RequestDto -> Entity
        Post post = new Post(requestDto);//requestDto를 Entity로 바꾸는 코드

        //2. Memo Max ID check
        Long maxId = postList.size() > 0 ? Collections.max(postList.keySet()) + 1 : 1;
        //postList Map의 size를 구해서 0보다 크'면' Map의 키를 다 대조해 거기에 1(다음값을 위한)을 더하라.
        //아니면 0 => 메모가 하나도 없다는 거니까 1(첫 게시글)을 대입
        //=>Post의 최대값 구해짐
        post.setId(maxId);//4. 구해진 ID값으로 메모의 id초기값에서 set으로 해줌

        //5. DB저장
        postList.put(post.getId(),post);

        //6. Entity -> ResponseDto => Entity를 ResponseDto로 변경 후 반환
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(){ //하나, 혹 여러개의 메모를 가져올 거기에 List.
        List<PostResponseDto> responseList = postList.values()
            .stream() //memoList의 value들을 for문같이 돌려줌
            .map(PostResponseDto::new ).toList(); //하나씩 나오는 메모를 변환 => .map(변환할객체Class::new)
        //=> 변환할 객체 호출
        return responseList;
    }

}
