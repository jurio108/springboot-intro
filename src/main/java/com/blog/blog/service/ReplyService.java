package com.blog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.blog.model.Reply;
import com.blog.blog.repository.ReplyRepository;

import jakarta.transaction.Transactional;

public class ReplyService {
  @Autowired
  private ReplyRepository replyRepository;

  @Transactional
  public Reply saveReply(Reply reply) {
    return replyRepository.save(reply);
  }
}
