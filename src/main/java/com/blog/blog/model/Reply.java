package com.blog.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reply {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id; // sequence
  
  @Column(nullable = false, length = 200)
  private String content;

  @CreationTimestamp
  private Timestamp createDate;

  @UpdateTimestamp
  private Timestamp updateDate;

  @ManyToOne
  @JoinColumn(name = "boardId")
  private Board board;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}
