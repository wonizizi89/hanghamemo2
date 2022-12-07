package com.example.hanghamemo2.service;

import com.example.hanghamemo2.dto.MemoRequestDto;
import com.example.hanghamemo2.entity.Memo;
import com.example.hanghamemo2.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;  //데이터베이스와 연결을 해야하기 때문에 연결 하는 부분인 MemoRepository를 사용할 수 있도록 추가
    //메모레포지토리에 연결이 되어 사용 할 수 있음
    @Transactional
    public Memo createMemo(MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo); //save함수 안에 memo인스턴스를 넣어주면 자동으로 쿼리가 생성면서 데이터베이스에 연결되며 저장이됨
        return memo;
    }

    @Transactional
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }
    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
        ()-> new IllegalArgumentException("아이디가 존재하지 않습니다. ")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
