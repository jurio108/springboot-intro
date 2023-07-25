package com.blog.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.model.User;
import com.blog.blog.model.UserRole;
import com.blog.blog.repository.UserRepository;

@RestController
public class DummyController {
  
  @Autowired
  private UserRepository userRepository;

  @GetMapping("dummy/user/{id}")
  public User user(@PathVariable int id) {
    User user = new User();

    // return이 Optional<T>이기 때문에 바로 return 불가능
    // user = userRepository.findById(id);
    // user = userRepository.findById(id).get();

    // .orElseGet : 조회 후 데이터가 없을때 데이터를 가져옴
    // user = userRepository.findById(id).orElseGet(new Supplier<User>() {
    //   @Override
    //   public User get() {
    //     return new User();
    //   }
    // });

    // .orElseThrow : 조회 후 데이터가 없을때 에러 강제 발생
    // user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
    //   @Override
    //   public IllegalArgumentException get() {
    //     return new IllegalArgumentException("not found user : " + id);
    //   }
    // });

    // orElseThrow > 람다식
    user =  userRepository.findById(id).orElseThrow(() -> {
      return new IllegalArgumentException("not found user [id : " + id + "]");
    });

    // return 시에 MessageConverter가 json으로 변환해줌
    // MessageConverter가 Jackson 라이브러리 호출함(변경가능)
    return user;
  }

  @GetMapping("dummy/user")
  public List<User> users() {
    return userRepository.findAll();
  }

  @GetMapping("dummy/user/page")
  public List<User> pageUsers(
    @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
    
    // return이 page<User>라 바로 return 불가능
    // return userRepository.findAll(pageable);

    return userRepository.findAll(pageable).getContent();
  }

  @PostMapping("dummy/join")
  public String join(User user) {
    user.setRole(UserRole.USER);
    userRepository.save(user);

    return "join complete";
  }
}
