package com.blog.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.blog.dto.ResponseDto;
import com.blog.blog.model.Reply;
import com.blog.blog.service.ReplyService;

public class ReplyApiController {
  @Autowired
  private ReplyService replyService;

  @PostMapping("/api/reply")
  public ResponseDto<Reply> createReply(@RequestBody Reply reply) {
    
    return new ResponseDto<Reply>(HttpStatus.OK.value(), replyService.saveReply(reply));
  }
}
