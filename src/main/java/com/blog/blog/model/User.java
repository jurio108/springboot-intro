package com.blog.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.blog.blog.test.dto.TestJpqlDto;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@SqlResultSetMapping(
  name = "countUserRoleMapping",
  classes = @ConstructorResult(
    targetClass = TestJpqlDto.class,
    columns = {
      @ColumnResult(name = "cntAdmin", type = Integer.class),
      @ColumnResult(name = "cntManager", type = Integer.class),
      @ColumnResult(name = "cntUser", type = Integer.class)
    }
  )
)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
// @DynamicInsert  // Insert 시 Null인 컬럼 제외
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id; // sequence
  
  @Column(nullable = false, length = 30)
  private String username;

  @Column(nullable = false, length = 100)
  private String password;

  @Column(nullable = false, length = 50)
  private String email;

  // @ColumnDefault("'user'")
  @Enumerated(EnumType.STRING)  // enum type 설정
  private UserRole role;

  // @Column(nullable = true)
  // @Embedded
  // @AttributeOverrides({
  //   @AttributeOverride(name = "state", column = @Column(name = "country"))
  // })
  // @Transient
  // private UserAddress address;

  @CreationTimestamp
  private Timestamp createDate;

  @UpdateTimestamp
  private Timestamp updateDate;

  // public void updateUserRole(UserRole userRole) {
  //   this.role = userRole;
  // }
}
