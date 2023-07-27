package com.blog.blog.repository.custom;

import java.util.List;

import com.blog.blog.model.User;

public interface UserRepositoryCustom {
  List<User> selectUsers(int id);
}
