package com.blog.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.blog.model.User;
import com.blog.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  /**
   * 로그인 요청을 spring이 가로챔
   * password 처리는 알아서 함
   * 
   * logout 처리는 할 필요가 없음
   * spring security에서 알아서 해줌 
   * 단 url은 /logout 고정
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("UserRepository :: loadUserByUsername");

    User principal = userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("Not Found Username : " + username));
    
    return new PrincipalDetail(principal);  // security 세션에 로그인 사용자 정보 저장
  }
  
}
