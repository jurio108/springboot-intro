package com.blog.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
public class Board {
  
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
  
  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}
