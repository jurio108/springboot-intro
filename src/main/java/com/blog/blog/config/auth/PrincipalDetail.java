package com.blog.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blog.blog.model.User;

import lombok.Getter;

/**
 * spring security 로그인 요청을 가로챔
 * 완료되면 UserDetail object를 spring security 세션 저장소에 저장
 */
@Getter
public class PrincipalDetail implements UserDetails {
  private User user;

  public PrincipalDetail(User user) {
    this.user = user;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  // 계정 만료 여부(true : 만료 안됨)
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // 계정 잠김 여부(true : 열림)
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // 비밀번호 만료 여부(true : 만료 안됨)
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // 계정 활성화 여부(true : 활성)
  @Override
  public boolean isEnabled() {
    return true;
  }

  // 권한 소유 정보
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    Collection<GrantedAuthority> collection = new ArrayList<>();

    // collection.add(new GrantedAuthority() {
    //   @Override
    //   public String getAuthority() {
    //     return "ROLE_" + user.getRole();
    //   }
    // });

    // ROLE_ :: spring prefix 규칙, 필수
    collection.add(() -> "ROLE_" + user.getRole());

    return collection;
  }
}
