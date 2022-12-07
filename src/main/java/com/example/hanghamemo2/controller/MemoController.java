package com.example.hanghamemo2.controller;

import com.example.hanghamemo2.dto.MemoRequestDto;
import com.example.hanghamemo2.entity.Memo;
import com.example.hanghamemo2.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService; //메모서비스도 불러와서 연결해줌

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){ //메모생성
                                       //requestDto 클라이언트한테 받아온 값을 주기 위함
        return memoService.createMemo(requestDto); //메모서비스의 createMemo 연결되는 부분의 메서드를 만들어주고
    } //메모를 바로 반환할 것이기 떄문에  넘어오는 값이 객체형식으로 넘어오기 때문에 @리퀘스트바디를 사용 함//포스트 방식이기대문에 그 바디안에 우리가 원하는 저장해야되는 것들이 넘어오게 때문에@리퀘스트 바디 사용할것이고 , 그리고 MemoRequestDto 객체를 받을 것임

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {//클라이언트에서 전달해주는 데이터가 없기 때문에  파라미터 없음
     return memoService.getMemos();
    }

    @PutMapping("/api/memos/{id}")  //pathVariable방식으로 id값을 보냄
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        return memoService.deleteMemo(id);
    }
}
