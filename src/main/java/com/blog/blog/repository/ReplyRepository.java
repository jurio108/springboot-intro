package com.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
  
}
