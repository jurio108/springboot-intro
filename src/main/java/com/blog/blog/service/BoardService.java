package com.blog.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.model.Board;
import com.blog.blog.model.User;
import com.blog.blog.repository.BoardRepository;

import org.springframework.transaction.annotation.Transactional;

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

  @Transactional(readOnly = true)
  public List<Board> boardList() {
    
    return boardRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Board board(int boardId) {
    return boardRepository.findById(boardId)
      .orElseThrow(()->{
        return new IllegalArgumentException("Not Found Board ID : " + boardId);
      });
  }

  @Transactional
  public void delete(int boardId) {
    Board board = this.board(boardId);

    if(board != null) {
      boardRepository.deleteById(boardId);
    }
  }

  @Transactional
  public void update(int id, Board board) {
    Board selectBoard = this.board(id);

    selectBoard.setTitle(board.getTitle());
    selectBoard.setContent(board.getContent());
  }
}
