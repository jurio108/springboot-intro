package com.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.blog.blog.service.BoardService;

@Controller
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping({"", "/"})
  public String index(Model model) {
    model.addAttribute("boards", boardService.boardList());
    
    // viewResolver 작동
    // model에 담긴 데이터를 같이 response
    return "index";
  }
    
  // @GetMapping({"", "/"})
  // public String index(
  //   @AuthenticationPrincipal PrincipalDetail principal
  // ) {
  //   System.out.println("BoardController :: login");
    
  //   if(principal == null) {
  //     return "user/loginForm";
  //   } else {
  //     System.out.println("login success : " + principal.getUsername());
  //     return "index";
  //   }
  // }
  
  @GetMapping({"/board/{id}"})
  public String board(@PathVariable int id, Model model) {
    model.addAttribute("board", boardService.board(id));
    return "board/detail";
  }

  @GetMapping({"/board/{id}/updateForm"})
  public String updateForm(@PathVariable int id, Model model) {
    model.addAttribute("board", boardService.board(id));
    return "board/updateForm";
  }

  @GetMapping({"/board/saveForm"})
  public String saveForm() {
    return "board/saveForm";
  }
}
