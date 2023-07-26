package com.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
  
}
