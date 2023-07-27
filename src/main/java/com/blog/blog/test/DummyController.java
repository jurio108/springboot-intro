package com.blog.blog.test;

import java.util.List;
// import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dto.ResponseDto;
import com.blog.blog.model.User;
import com.blog.blog.model.UserRole;
import com.blog.blog.repository.UserRepository;
import com.blog.blog.test.dto.TestJpqlDto;
import com.blog.blog.test.service.TestJpqlService;

import jakarta.transaction.Transactional;

@RestController
public class DummyController {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TestJpqlService testJpqlService;

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

  @Transactional  // 메서드가 끝날때 트랜잭션 종료되면서 자동 commit, 더티체킹(Persistence Context)
  @PutMapping("dummy/user/{id}")
  public User updateUser(@PathVariable int id, @RequestBody User user) {
    User selectedUser = this.user(id);
    selectedUser.setPassword(user.getPassword());
    selectedUser.setEmail(user.getEmail());

    // User updatedUser = userRepository.save(selectedUser);
    // return updatedUser;

    return selectedUser;
  }

  @DeleteMapping("dummy/user/{id}")
  public String deleteUser(@PathVariable int id) {
    User selectedUser = this.user(id);
    userRepository.deleteById(selectedUser.getId());
    return "delete complete";
  }

  @PostMapping("dummy/join")
  public String join(@RequestBody User user) {
    user.setRole(UserRole.USER);
    userRepository.save(user);

    return "join complete";
  }

  @GetMapping("dummy/jpql")
  public ResponseDto<List<TestJpqlDto>> testJpql() {
    return new ResponseDto<List<TestJpqlDto>>(HttpStatus.OK.value(), testJpqlService.testJpql());
  }

  @GetMapping("dummy/querydsl")
  public List<User> testQuerydsl(@RequestParam int id) {    
    return testJpqlService.testQuerydsl(id);
  }
}
