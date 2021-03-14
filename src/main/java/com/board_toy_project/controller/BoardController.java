package com.board_toy_project.controller;

import com.board_toy_project.BoardToyProjectApplication;
import com.board_toy_project.domain.BoardVO;
import com.board_toy_project.repository.SpringDataJpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final SpringDataJpaBoardRepository springDataJpaBoardRepository;

    @GetMapping("/board")
    public List<BoardVO> getAllBoard() {
        return springDataJpaBoardRepository.findAll();
    }

    @GetMapping("/board/{id}")
    public BoardVO getBoardVO(@PathVariable String id) {
        Long boardID = Long.parseLong(id);
        Optional<BoardVO> boardVO = springDataJpaBoardRepository.findById(boardID);
        return boardVO.get();
    }

    @PostMapping("/post/{id}")
    public BoardVO createBoard(@PathVariable String id, @RequestBody BoardVO newBoard) {
        Long boardID = Long.parseLong(id);

        Optional<BoardVO> boardVO = springDataJpaBoardRepository.findById(boardID);

        boardVO.get().setTitle(newBoard.getTitle());
        boardVO.get().setContent(newBoard.getContent());
        boardVO.get().setWriter(newBoard.getWriter());
        boardVO.get().setTimestamp(newBoard.getTimestamp());

        springDataJpaBoardRepository.save(boardVO.get());

        return boardVO.get();
    }

    @PutMapping("/post")
    public BoardVO createBoard(@RequestBody BoardVO boardVO) {
        BoardVO newBoard = springDataJpaBoardRepository.save(boardVO);

        return newBoard;
    }

    @DeleteMapping("/post/{id}")
    public String deleteBoard(@PathVariable String id) {
        Long boardID=Long.parseLong(id);
        springDataJpaBoardRepository.deleteById(boardID);

        return "삭제 성공";
    }

}
