package com.blog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.blog.model.Board;
import com.blog.blog.repository.BoardRepository;

import jakarta.transaction.Transactional;

public class BoardService {
  @Autowired
  private BoardRepository boardRepository;

  @Transactional
  public Board saveBoard(Board board) {
    return boardRepository.save(board);
  }
}
