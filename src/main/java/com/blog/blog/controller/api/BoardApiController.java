package com.blog.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.blog.dto.ResponseDto;
import com.blog.blog.model.Board;
import com.blog.blog.service.BoardService;

public class BoardApiController {
  @Autowired
  private BoardService boardService;

  @PostMapping("/api/board")
  public ResponseDto<Board> createBoard(@RequestBody Board board) {
    
    return new ResponseDto<Board>(HttpStatus.OK.value(), boardService.saveBoard(board));
  }
}
