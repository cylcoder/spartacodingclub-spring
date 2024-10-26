package com.sparta.memo.entity;

import com.sparta.memo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Memo {

    private Long id;
    private String username;
    private String contents;

    public Memo(MemoRequestDto requestDto) {
        username = requestDto.getUsername();
        contents = requestDto.getContents();
    }

}