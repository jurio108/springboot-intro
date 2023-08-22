package com.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog.model.User;
import com.blog.blog.repository.custom.UserRepositoryCustom;

/**
 * JpaRepository<User, Integer> 뜻 : User 테이블 관리 repository, 해당 테이블의 pk는 integer
 */
// @Repository : 이제 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
  // JPA naming query
  // select * from user where username = ?1 and password = ?2
  User findByUsernameAndPassword(String username, String password);
}
