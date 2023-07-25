package com.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog.model.User;

/**
 * JpaRepository<User, Integer> 뜻 : User 테이블 관리 repository, 해당 테이블의 pk는 integer
 */
// @Repository : 이제 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
