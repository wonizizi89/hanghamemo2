package com.example.hanghamemo2.dto;

import lombok.Getter;

@Getter // user 이름이랑 컨텐츠를 받아와야 함. 클라이언트에서 넘어오는 유저네임과 컨텐츠를 이 객체를 통해서 받아 보도록 할것임
public class MemoRequestDto {
    private String username;
    private String contents;
}
