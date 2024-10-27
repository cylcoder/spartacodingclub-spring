package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto to Entity
        Memo memo = new Memo(requestDto);

        Long id = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
        memo.setId(id);
        memoList.put(id, memo);

        // Entity to ResponseDto
        return new MemoResponseDto(memo);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        return memoList.values().stream().map(MemoResponseDto::new).toList();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        if (!memoList.containsKey(id)) {
            throw new IllegalArgumentException("존재하지 않는 메모입니다.");
        }

        Memo memo = memoList.get(id);
        memo.update(requestDto);
        return id;
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        if (!memoList.containsKey(id)) {
            throw new IllegalArgumentException("존재하지 않는 메모입니다.");
        }

        memoList.remove(id);
        return id;
    }

}
