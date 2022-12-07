package com.example.hanghamemo2.repository;


import com.example.hanghamemo2.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();//수정된 시간이 가장최근인 순서로 가지고 와야 메모가 가장 위로 올라오기 때문에 내림차순으로 설정
}