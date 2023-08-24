package com.blog.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.config.auth.PrincipalDetail;
import com.blog.blog.dto.ResponseDto;
import com.blog.blog.model.Board;
import com.blog.blog.service.BoardService;

@RestController
public class BoardApiController {

  @Autowired
  private BoardService boardService;

  @PostMapping("/api/board")
  public ResponseDto<Integer> save(
    @RequestBody Board board,
    @AuthenticationPrincipal PrincipalDetail principal) {
    boardService.save(board, principal.getUser());
    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
  }
}
