package com.blog.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Board {
  
  // @Data
  // @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id; // sequence
  
  @Column(nullable = false, length = 100)
  private String title;

  @Lob
  private String content;

  @ColumnDefault("0")
  private int count;

  @CreationTimestamp
  private Timestamp createDate;

  @UpdateTimestamp
  private Timestamp updateDate;
  
  // FetchType.EAGER : 즉시로딩(조인 후 쿼리 1개)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "userId")
  private User user;
  
  // mappedBy : column 생성하지 않음
  // FetchType.LAZY : 지연로딩(data조회를 바로 하지 않음, 조인하지 않고 따로 조회)
  // @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
  @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
  private List<Reply> reply;
}
