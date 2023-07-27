package com.blog.blog.repository.custom;

import java.util.List;

import com.blog.blog.model.QUser;
import com.blog.blog.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
  private final JPAQueryFactory queryFactory;

  @Override
  public List<User> selectUsers(int id) {
    QUser user = new QUser("a");

    return queryFactory
              .selectFrom(user)
              .where(user.id.eq(id))
              .fetch();
  }
  
}
