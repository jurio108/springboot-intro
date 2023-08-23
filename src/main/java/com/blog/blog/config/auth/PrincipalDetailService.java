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
   * login 요청을 spring이 가로챔
   * password 처리는 알아서 함
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("UserRepository :: loadUserByUsername");

    User principal = userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("Not Found Username : " + username));
    
    return new PrincipalDetail(principal);  // security 세션에 정보 저장
  }
  
}
