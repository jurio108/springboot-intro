package com.blog.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.model.Board;
import com.blog.blog.model.User;
import com.blog.blog.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Transactional
  public void save(Board board, User user) { // title, content
    board.setCount(0);
    board.setUser(user);
    boardRepository.save(board);
  }

  public List<Board> boardList() {
    return boardRepository.findAll();
  }
}
